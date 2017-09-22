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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.atmdigital.crmapi.model.Contato;
import br.com.atmdigital.crmapi.service.ContatoService;

/**
 * 
 * @author Bruno Bertelli
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value="/private/contato")
public class RESTContatoController {

	Logger LOGGER = LogManager.getLogger(RESTContatoController.class);

	@Autowired 
	ContatoService contatoService;

	@ResponseBody
	@RequestMapping(value = "/getContatosCliente/{idCliente}", method = RequestMethod.GET)
	public ResponseEntity<List<Contato>> getContatosCliente(@PathVariable("idCliente") long idCliente) throws Exception {
		return new ResponseEntity<List<Contato>>(contatoService.getContatosCliente(idCliente),HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/salvarContato", method = RequestMethod.POST)
	public ResponseEntity<Contato> salvarContato(@RequestBody Contato contato) throws Exception {		
		contatoService.save(contato);
		return new ResponseEntity<Contato>(HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value="/desativarContato", method = RequestMethod.POST)
	public ResponseEntity<List<Contato>> desativarContato(@RequestBody Contato contato) throws Exception {
		contato.setAtivo(0);
		contatoService.save(contato);

		return new ResponseEntity<List<Contato>>(HttpStatus.OK);
	}

}
