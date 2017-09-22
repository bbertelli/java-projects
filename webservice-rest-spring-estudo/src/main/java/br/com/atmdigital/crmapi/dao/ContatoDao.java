package br.com.atmdigital.crmapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.atmdigital.crmapi.common.dao.AbstractDao;
import br.com.atmdigital.crmapi.model.Contato;

@Repository
public interface ContatoDao extends AbstractDao<Contato, Long>{
	
	@Query("SELECT c"
    		+ " FROM Contato c JOIN c.cliente cl"
    		+ " WHERE cl.id = :idCliente"
    		+ " AND c.ativo = 1"
    		+ " ORDER BY c.nome")
    public List<Contato> getContatosCliente(@Param("idCliente") long idCliente);
	
}
