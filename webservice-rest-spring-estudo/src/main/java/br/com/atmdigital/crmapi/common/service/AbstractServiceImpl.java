package br.com.atmdigital.crmapi.common.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.configuration.Configuration;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Bruno Bertelli
 *
 */
@Getter @Setter
public abstract class AbstractServiceImpl {

	protected static final Logger LOGGER = LogManager.getLogger(AbstractServiceImpl.class);
		
	@PersistenceContext
	protected EntityManager entityManager;
		
	/**
	 * Classe que reprenseta configuração da aplicação.
	 */
	@Autowired
	protected Configuration config;

	protected ObjectMapper mapper = new ObjectMapper();
	
	protected RestTemplate restTemplate = new RestTemplate();
	
}
