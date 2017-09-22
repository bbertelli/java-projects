package br.com.atmdigital.crmapi.rest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.atmdigital.crmapi.model.Usuario;
import br.com.atmdigital.crmapi.service.UsuarioService;

/**
 * @author Bruno Bertelli
 *
 */
@CrossOrigin
@RestController
public class RESTUsuarioController {

	Logger LOGGER = LogManager.getLogger(RESTUsuarioController.class);

	@Autowired
	UsuarioService usuarioService;
	
	@ResponseBody
	@RequestMapping(value = "/cadastrarAtualizarUsuario", method = RequestMethod.POST)
	public ResponseEntity<Usuario> cadastrarAtualizarUsuario(@RequestBody Usuario usuario) throws Exception {
		
		return new ResponseEntity<Usuario>(usuarioService.save(usuario), HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/removerUsuario", method = RequestMethod.POST)
	public ResponseEntity<Usuario> removerUsuario(@RequestBody Usuario usuario) throws Exception {
		
		usuario.setAtivo(0);
		
		return new ResponseEntity<Usuario>(usuarioService.save(usuario), HttpStatus.OK);
	}
}
