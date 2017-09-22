package br.com.atmdigital.crmapi.service.impl;

import javax.transaction.NotSupportedException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.atmdigital.crmapi.common.service.AbstractEntityServiceImpl;
import br.com.atmdigital.crmapi.dao.RemuneracaoDao;
import br.com.atmdigital.crmapi.model.Usuario;
import br.com.atmdigital.crmapi.service.RemuneracaoService;
import lombok.Getter;
import lombok.Setter;

@Service
@Transactional
@Getter @Setter
public class RemuneracaoServiceImpl extends AbstractEntityServiceImpl<Usuario,RemuneracaoDao,Long> implements RemuneracaoService{

	@Override
	public Usuario save(Usuario entity) throws Exception {
		throw new NotSupportedException();
	}

	@Override
	public void delete(Usuario entity) throws Exception {
		throw new NotSupportedException();
	}

}
