package br.com.atmdigital.crmapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.atmdigital.crmapi.common.dao.AbstractDao;
import br.com.atmdigital.crmapi.model.Cliente;

@Repository
public interface ClienteDao extends AbstractDao<Cliente, Long>{
	
	@Query("SELECT c"
			+ " FROM Cliente c, Visita v"
			+ " WHERE c.id = v.cliente.id"
			+ " AND v.dataFechamento < current_date - :qtdDias"
			+ " AND v.usuario.id = :idUsuario"
			+ " AND c.ativo = 1")
	public List<Cliente> buscarClientesSemVisitas(@Param("idUsuario") long idUsuario, @Param("qtdDias") int qtdDias);
	
}
