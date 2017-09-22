package br.com.atmdigital.crmapi.rest;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.atmdigital.crmapi.model.ClienteUsuario;
import br.com.atmdigital.crmapi.service.ClienteUsuarioService;

/**
 * 
 * @author Bruno Bertelli
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value="/private/cliente")
public class RESTClienteUsuarioController {

	Logger LOGGER = LogManager.getLogger(RESTClienteUsuarioController.class);
	
	@Autowired 
	ClienteUsuarioService clienteUsuarioService;
	
	@ResponseBody
	@RequestMapping(value = "/buscarClientesPorIdUsuario/{idUsuario}", method = RequestMethod.GET)
	public ResponseEntity<List<ClienteUsuario>> buscarClientesPorIdUsuario(@PathVariable("idUsuario") long idUsuario)
			throws Exception {

		return new ResponseEntity<List<ClienteUsuario>>(clienteUsuarioService.buscarClientesPorIdUsuario(idUsuario), HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/buscarClientesFavoritos/{idUsuario}", method = RequestMethod.GET)
	public ResponseEntity<List<ClienteUsuario>> buscarClientesFavoritos(@PathVariable("idUsuario") long idUsuario)
			throws Exception {

		return new ResponseEntity<List<ClienteUsuario>>(clienteUsuarioService.buscarClientesFavoritos(idUsuario), HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/buscarClientesPorFiltros", method = RequestMethod.GET)
	public ResponseEntity<List<ClienteUsuario>> buscarClientesPorFiltros(@RequestParam("nome") String nome,
			@RequestParam("cidade") String cidade, @RequestParam("estado") String estado, 
			@RequestParam("idUsuario") long idUsuario) throws Exception {

		return new ResponseEntity<List<ClienteUsuario>>(clienteUsuarioService.buscarClientesPorFiltros(nome, cidade, estado, idUsuario),HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/buscarClientesPorInicial", method = RequestMethod.GET)
	public ResponseEntity<List<ClienteUsuario>> buscarClientesPorInicial(@RequestParam("letraInicial") String letraInicial,
			@RequestParam("cidade") String cidade, @RequestParam("estado") String estado, 
			@RequestParam("idUsuario") long idUsuario) throws Exception {

		return new ResponseEntity<List<ClienteUsuario>>(clienteUsuarioService.buscarClientesPorInicial(letraInicial, cidade, estado, idUsuario),HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getInfoCliente", method = RequestMethod.GET)
	public ResponseEntity<ClienteUsuario> getInfoCliente(@RequestParam("idCliente") long idCliente,
			@RequestParam("idUsuario") long idUsuario) throws Exception {

		return new ResponseEntity<ClienteUsuario>(clienteUsuarioService.getInfoCliente(idCliente, idUsuario), HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/salvarFavorito", method = RequestMethod.GET)
	public ResponseEntity<ClienteUsuario> salvarFavorito(@RequestParam("idCliente") long idCliente,
			@RequestParam("idUsuario") long idUsuario) throws Exception {

		clienteUsuarioService.salvarFavorito(idCliente, idUsuario);
		
		return new ResponseEntity<ClienteUsuario>(HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/removerFavorito", method = RequestMethod.GET)
	public ResponseEntity<ClienteUsuario> removerFavorito(@RequestParam("idCliente") long idCliente,
			@RequestParam("idUsuario") long idUsuario) throws Exception {

		clienteUsuarioService.removerFavorito(idCliente, idUsuario);
		
		return new ResponseEntity<ClienteUsuario>(HttpStatus.OK);
	}
	
	/*@ResponseBody
	@RequestMapping(value = "/cadastrarAtualizarClienteUsuario", method = RequestMethod.POST)
	public ResponseEntity<ClienteUsuario> cadastrarAtualizarClienteUsuario(@RequestBody ClienteUsuario clienteUsuario) throws Exception {

		clienteUsuarioService.save(clienteUsuario);
		
		return new ResponseEntity<ClienteUsuario>(HttpStatus.OK);
	}*/
	
	@ResponseBody
	@RequestMapping(value = "/removerClienteUsuario", method = RequestMethod.POST)
	public ResponseEntity<ClienteUsuario> removerClienteUsuario(@RequestBody ClienteUsuario clienteUsuario) throws Exception {

		clienteUsuarioService.delete(clienteUsuario);
		
		return new ResponseEntity<ClienteUsuario>(HttpStatus.OK);
	}
}
