package br.com.atmdigital.crmapi.dao;

import org.springframework.stereotype.Repository;

import br.com.atmdigital.crmapi.common.dao.AbstractDao;
import br.com.atmdigital.crmapi.model.Usuario;

@Repository
public interface RemuneracaoDao extends AbstractDao<Usuario, Long>{
	
}
