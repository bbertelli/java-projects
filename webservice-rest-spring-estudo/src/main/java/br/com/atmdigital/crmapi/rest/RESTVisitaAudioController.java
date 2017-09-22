package br.com.atmdigital.crmapi.rest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping(value="/visita")
public class RESTVisitaAudioController {

	Logger LOGGER = LogManager.getLogger(RESTVisitaAudioController.class);

	@Autowired
	VisitaService visitasService;
	
	@ResponseBody
	@RequestMapping(value = "/updateRecordAudio", method = RequestMethod.POST)
	public ResponseEntity<Visita> updateVistaWithRecordAudio(@RequestParam(name="text") String text,
			@RequestParam(name="idVisita") Long idVisita) throws Exception {
		
		Visita visita = visitasService.findOne(idVisita);
		visita.setReporte(text);
		visita.setAudioGravado(idVisita+".3gp");
		visitasService.save(visita);
				
		return new ResponseEntity<Visita>(HttpStatus.OK);
	}

}
