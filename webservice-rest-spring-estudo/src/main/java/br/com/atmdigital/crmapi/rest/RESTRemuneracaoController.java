package br.com.atmdigital.crmapi.rest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.atmdigital.crmapi.service.RemuneracaoService;

/**
 * 
 * @author Bruno Bertelli
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value="/private/remuneracao")
public class RESTRemuneracaoController {

	Logger LOGGER = LogManager.getLogger(RESTRemuneracaoController.class);

	@Autowired 
	RemuneracaoService remuneracaoService;
	
}
