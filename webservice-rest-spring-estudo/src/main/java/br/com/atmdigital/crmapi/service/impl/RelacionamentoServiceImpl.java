package br.com.atmdigital.crmapi.service.impl;

import br.com.atmdigital.crmapi.common.service.AbstractEntityServiceImpl;
import br.com.atmdigital.crmapi.dao.RelacionamentoDao;
import br.com.atmdigital.crmapi.model.Relacionamento;
import br.com.atmdigital.crmapi.service.RelacionamentoService;

public class RelacionamentoServiceImpl extends AbstractEntityServiceImpl<Relacionamento,RelacionamentoDao,Long> implements RelacionamentoService{

	@Override
	public Relacionamento save(Relacionamento orcamento) throws Exception {
		return getDao().save(orcamento);
	}
	
}
