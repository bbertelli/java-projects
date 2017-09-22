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

import br.com.atmdigital.crmapi.model.Visita;
import br.com.atmdigital.crmapi.service.VisitaService;

/**
 * 
 * @author Bruno Bertelli
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value="/private/visita")
public class RESTVisitaController {

	Logger LOGGER = LogManager.getLogger(RESTVisitaController.class);

	@Autowired 
	VisitaService visitasService;

	@ResponseBody
	@RequestMapping(value = "/buscarVisitasFechadasTodosClientes", method = RequestMethod.GET)
	public ResponseEntity<List<Visita>> buscarVisitasFechadasTodosClientes(@RequestParam(name="idUsuario") long idUsuario,
			@RequestParam(name="cidade") String cidade, @RequestParam("estado") String estado,
			@RequestParam("mes") int mes, @RequestParam("ano") int ano) throws Exception {
		
		return new ResponseEntity<List<Visita>>(visitasService.buscarVisitasFechadasTodosClientes(idUsuario, cidade, estado, mes, ano),HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/buscarVisitasFechadasCliente", method = RequestMethod.GET)
	public ResponseEntity<List<Visita>> buscarVisitasFechadasCliente(@RequestParam(name="idCliente") long idCliente, @RequestParam (name="idUsuario") long idUsuario,
			@RequestParam(name="cidade") String cidade, @RequestParam("estado") String estado,
			@RequestParam("mes") int mes, @RequestParam("ano") int ano) throws Exception {
		
		return new ResponseEntity<List<Visita>>(visitasService.buscarVisitasFechadasCliente(idCliente, idUsuario, cidade, estado, mes, ano),HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/buscarVisitasAbertasTodosClientes", method = RequestMethod.GET)
	public ResponseEntity<List<Visita>> buscarVisitasAbertasTodosClientes(@RequestParam(name="idUsuario") long idUsuario,
			@RequestParam(name="cidade") String cidade, @RequestParam("estado") String estado,
			@RequestParam("mes") int mes, @RequestParam("ano") int ano) throws Exception {
		
		return new ResponseEntity<List<Visita>>(visitasService.buscarVisitasAbertasTodosClientes(idUsuario, cidade, estado, mes, ano),HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/buscarVisitasAbertasCliente", method = RequestMethod.GET)
	public ResponseEntity<List<Visita>> buscarVisitasAbertasCliente(@RequestParam(name="idCliente") long idCliente, @RequestParam(name="idUsuario") long idUsuario,
			@RequestParam(name="cidade") String cidade, @RequestParam("estado") String estado,
			@RequestParam("mes") int mes, @RequestParam("ano") int ano) throws Exception {
		
		return new ResponseEntity<List<Visita>>(visitasService.buscarVisitasAbertasCliente(idCliente, idUsuario, cidade, estado, mes, ano),HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/buscarTodasVisitasCliente", method = RequestMethod.GET)
	public ResponseEntity<List<Visita>> buscarTodasVisitasCliente(@RequestParam(name="idCliente") long idCliente, @RequestParam(name="idUsuario") long idUsuario,
			@RequestParam(name="cidade") String cidade, @RequestParam("estado") String estado,
			@RequestParam("mes") int mes, @RequestParam("ano") int ano) throws Exception {
		
		return new ResponseEntity<List<Visita>>(visitasService.buscarTodasVisitasCliente(idCliente, idUsuario, cidade, estado, mes, ano),HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/buscarTodasVisitasTodosClientes", method = RequestMethod.GET)
	public ResponseEntity<List<Visita>> buscarTodasVisitasTodosClientes(@RequestParam(name="idUsuario") long idUsuario,
			@RequestParam(name="cidade") String cidade, @RequestParam("estado") String estado,
			@RequestParam("mes") int mes, @RequestParam("ano") int ano) throws Exception {
		
		return new ResponseEntity<List<Visita>>(visitasService.buscarTodasVisitasTodosClientes(idUsuario, cidade, estado, mes, ano),HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/registrarVisita", method = RequestMethod.POST)
	public ResponseEntity<Visita> registrarVisita(@RequestBody Visita visita) throws Exception {
		visitasService.save(visita);
		
		return new ResponseEntity<Visita>(HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/agendarVisita", method = RequestMethod.POST)
	public ResponseEntity<Visita> agendarVisita(@RequestBody Visita visita) throws Exception {
		visitasService.save(visita);
		
		return new ResponseEntity<Visita>(HttpStatus.OK);
	}
}
