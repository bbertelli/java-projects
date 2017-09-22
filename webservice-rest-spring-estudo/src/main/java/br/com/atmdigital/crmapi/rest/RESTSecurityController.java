package br.com.atmdigital.crmapi.rest;

import org.apache.commons.configuration.Configuration;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.atmdigital.crmapi.model.Usuario;
import br.com.atmdigital.crmapi.service.UsuarioService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author Bruno Bertelli
 *
 */
@CrossOrigin
@RestController
public class RESTSecurityController {

	Logger LOGGER = LogManager.getLogger(RESTSecurityController.class);

	@Autowired
	protected Configuration config;

	@Autowired
	UsuarioService usuarioService;
	
	private static ObjectMapper mapper = new ObjectMapper();

	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Usuario> login(@RequestParam(name="usuario") String usuario, 
			@RequestParam(name="senha") String senha) throws Exception {

		try {
			Usuario usuarioAutenticado = usuarioService.buscarUsuario(usuario, senha);
				
			if(usuarioAutenticado != null){
	
				DateTime d = new DateTime();
				d = d.plusHours(config.getInt("time.expired", 1));
			
				String token = Jwts.builder().setExpiration(d.toDate()).setSubject(mapper.writeValueAsString(usuarioAutenticado))
						.signWith(SignatureAlgorithm.HS512, config.getString("keytoken")).compact();
				
				usuarioAutenticado.setToken(token);
				
				return new ResponseEntity<Usuario>(usuarioAutenticado, HttpStatus.OK);
			}else{
				return new ResponseEntity<Usuario>(HttpStatus.UNAUTHORIZED);
			}
		} catch (HttpClientErrorException e) {
			return new ResponseEntity<Usuario>(e.getStatusCode());
		} catch (Exception e) {
			return new ResponseEntity<Usuario>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/verificarToken", method = RequestMethod.POST)
	public ResponseEntity<Usuario> validateToken(@RequestParam(value="token") String token) throws Exception {

		try {
			Claims claims = Jwts.parser().setSigningKey(config.getString("keytoken")).parseClaimsJws(token).getBody();	
			Usuario user = mapper.readValue(claims.getSubject(), Usuario.class);
			
			Usuario usuarioAutenticado = usuarioService.buscarUsuarioPorToken(user.getToken());
			
			if(usuarioAutenticado != null){
				return new ResponseEntity<Usuario>(usuarioAutenticado, HttpStatus.OK);
			}else{
				return new ResponseEntity<Usuario>(HttpStatus.UNAUTHORIZED);
			}
		} catch (Exception e) {
			LOGGER.error(e);
			return new ResponseEntity<Usuario>(HttpStatus.UNAUTHORIZED);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResponseEntity<Usuario> logout() throws Exception {

		return new ResponseEntity<Usuario>(HttpStatus.OK);
	}
}
