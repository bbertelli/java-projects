package br.com.atmdigital.crmapi.rest;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.atmdigital.crmapi.model.Cliente;
import br.com.atmdigital.crmapi.model.Usuario;
import br.com.atmdigital.crmapi.service.ClienteService;

/**
 * 
 * @author Bruno Bertelli
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value="/private/cliente")
public class RESTClienteController {

	Logger LOGGER = LogManager.getLogger(RESTClienteController.class);

	@Autowired 
	ClienteService clienteService;
	
	@ResponseBody
	@RequestMapping(value = "/salvarContatoPadrao", method = RequestMethod.POST)
	public ResponseEntity<Cliente> salvarContatoPadrao(@RequestParam("idCliente") long idCliente,
			@RequestParam("idContato") int idContato) throws Exception {
		
		Cliente c = clienteService.findOne(idCliente);
		c.setContatoPadrao(idContato);
		clienteService.save(c);
		
		return new ResponseEntity<Cliente>(HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/registrarNovoCliente", method = RequestMethod.POST)
	public ResponseEntity<Cliente> registrarNovoCliente(@RequestBody Cliente cliente, 
			@RequestParam("idUsuario") long idUsuario,
			@RequestParam("favorito") int favorito) throws Exception {
					
		clienteService.registrarNovoCliente(cliente, new Usuario(idUsuario), favorito);
		
		return new ResponseEntity<Cliente>(HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/atualizarCliente", method = RequestMethod.POST)
	public ResponseEntity<Cliente> atualizarCliente(@RequestBody Cliente cliente) throws Exception {	
		clienteService.save(cliente);
		return new ResponseEntity<Cliente>(HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/desativarCliente", method = RequestMethod.POST)
	public ResponseEntity<Cliente> desativarCliente(@RequestBody Cliente cliente) throws Exception {

		cliente.setAtivo(0);
		clienteService.save(cliente);
		
		return new ResponseEntity<Cliente>(HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/buscarClientesSemVisitas", method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> buscarClientesSemVisitas(@RequestParam("idUsuario") long idUsuario, @RequestParam int qtdDias)
			throws Exception {
		
		return new ResponseEntity<List<Cliente>>(clienteService.buscarClientesSemVisitas(idUsuario, qtdDias), HttpStatus.OK);
	}
}
