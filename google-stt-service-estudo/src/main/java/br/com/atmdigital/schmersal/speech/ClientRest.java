package br.com.atmdigital.schmersal.speech;

import org.apache.log4j.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ClientRest {

	final static Logger _logger = Logger.getLogger(ClientRest.class);

	private static Client client;
	private static WebResource webResource;
	
	static {
		client = Client.create();
		webResource = client.resource("http://localhost:8088/crm-api/api/visita/updateRecordAudio");
	}

	public static void send(String idVisita, String text) throws BusinessException{
	
		try {
			_logger.info("Send text ....");
			
			ClientResponse response = webResource.queryParam("text", text).queryParam("idVisita", idVisita).post(ClientResponse.class);
			if (response.getStatus() != 200){
				throw new BusinessException("Fail to send text to api idVisita = " + idVisita);
			}
		} catch (Exception e) {
			_logger.error(e);
			throw new BusinessException();
		}
	}
}
