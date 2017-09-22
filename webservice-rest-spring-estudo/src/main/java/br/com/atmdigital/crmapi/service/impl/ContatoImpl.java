package br.com.atmdigital.crmapi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.atmdigital.crmapi.common.service.AbstractEntityServiceImpl;
import br.com.atmdigital.crmapi.dao.ContatoDao;
import br.com.atmdigital.crmapi.model.Contato;
import br.com.atmdigital.crmapi.service.ContatoService;
import lombok.Getter;
import lombok.Setter;

@Service
@Transactional
@Getter @Setter
public class ContatoImpl extends AbstractEntityServiceImpl<Contato,ContatoDao,Long> implements ContatoService{

	public List<Contato> getContatosCliente(long idCliente){
		return getDao().getContatosCliente(idCliente);
	}
	
	@Override
	public void delete(Contato entity) throws Exception {
		getDao().delete(entity);
	}

	@Override
	public Contato save(Contato entity) throws Exception {
		return getDao().save(entity);
	}

}
