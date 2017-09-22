package br.com.atmdigital.crmapi.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.atmdigital.crmapi.common.service.AbstractEntityServiceImpl;
import br.com.atmdigital.crmapi.dao.RelacionamentoHistoricoDAO;
import br.com.atmdigital.crmapi.model.RelacionamentoHistorico;
import br.com.atmdigital.crmapi.service.RelacionamentoHistoricoService;
import lombok.Getter;
import lombok.Setter;

@Service
@Transactional
@Getter @Setter
public class RelacionamentoHistoricoImpl extends AbstractEntityServiceImpl<RelacionamentoHistorico,RelacionamentoHistoricoDAO,Long> implements RelacionamentoHistoricoService{

	@Override
	public RelacionamentoHistorico save(RelacionamentoHistorico followUp) throws Exception {
		return getDao().save(followUp);
	}
}
