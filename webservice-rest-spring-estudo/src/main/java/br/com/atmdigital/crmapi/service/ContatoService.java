package br.com.atmdigital.crmapi.service;

import java.util.List;

import br.com.atmdigital.crmapi.common.service.IService;
import br.com.atmdigital.crmapi.model.Contato;


public interface ContatoService extends IService<Contato,Long>{
	
	public List<Contato> getContatosCliente(long idCliente);

}
