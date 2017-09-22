package br.com.atmdigital.crmapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.atmdigital.crmapi.common.dao.AbstractDao;
import br.com.atmdigital.crmapi.model.Visita;

@Repository
public interface VisitaDao extends AbstractDao<Visita, Long>{

	@Query("SELECT v"
			+ " FROM Visita v, Usuario u, Cliente c"
			+ " WHERE v.cliente.id = c.id"
			+ " AND v.usuario.id = :idUsuario"
			+ " AND c.cidade LIKE CONCAT('%',:cidade,'%')"
			+ " AND c.estado LIKE CONCAT('%',:estado,'%')"
			+ " AND date_part('month', v.dataFechamento) = :mes"
			+ " AND date_part('year', v.dataFechamento) = :ano"
			+ " AND v.situacaoVisita.id IN (2,3)"
			+ " ORDER BY v.dataFechamento ASC")
	public List<Visita> buscarVisitasFechadasTodosClientes(@Param("idUsuario") long idUsuario, 
			@Param("cidade") String cidade, @Param("estado") String estado,
			@Param("mes") int mes, @Param("ano") int ano);
	
	@Query("SELECT v"
			+ " FROM Visita v, Usuario u, Cliente c"
			+ " WHERE v.cliente.id = c.id"
			+ " AND c.id = :idCliente"
			+ " AND v.usuario.id = :idUsuario"
			+ " AND c.cidade LIKE CONCAT('%',:cidade,'%')"
			+ " AND c.estado LIKE CONCAT('%',:estado,'%')"
			+ " AND date_part('month', v.dataFechamento) = :mes"
			+ " AND date_part('year', v.dataFechamento) = :ano"
			+ " AND v.situacaoVisita.id IN (2,3)"
			+ " ORDER BY v.dataFechamento ASC")
	public List<Visita> buscarVisitasFechadasCliente(@Param("idCliente") long idCliente, 
			@Param("idUsuario") long idUsuario, @Param("cidade") String cidade, 
			@Param("estado") String estado, @Param("mes") int mes, @Param("ano") int ano);
	
	@Query("SELECT v"
			+ " FROM Visita v, Usuario u, Cliente c"
			+ " WHERE v.cliente.id = c.id"
			+ " AND v.usuario.id = :idUsuario"
			+ " AND c.cidade LIKE CONCAT('%',:cidade,'%')"
			+ " AND c.estado LIKE CONCAT('%',:estado,'%')"
			+ " AND date_part('month', v.dataPlanejada) = :mes"
			+ " AND date_part('year', v.dataPlanejada) = :ano"
			+ " AND v.situacaoVisita.id = 1"
			+ " ORDER BY v.dataPlanejada ASC")
	public List<Visita> buscarVisitasAbertasTodosClientes(@Param("idUsuario") long idUsuario, 
			@Param("cidade") String cidade, @Param("estado") String estado,
			@Param("mes") int mes, @Param("ano") int ano);
	
	@Query("SELECT v"
			+ " FROM Visita v, Usuario u, Cliente c"
			+ " WHERE v.cliente.id = c.id"
			+ " AND c.id = :idCliente"
			+ " AND v.usuario.id = :idUsuario"
			+ " AND c.cidade LIKE CONCAT('%',:cidade,'%')"
			+ " AND c.estado LIKE CONCAT('%',:estado,'%')"
			+ " AND date_part('month', v.dataPlanejada) = :mes"
			+ " AND date_part('year', v.dataPlanejada) = :ano"
			+ " AND v.situacaoVisita.id = 1"
			+ " ORDER BY v.dataPlanejada ASC")
	public List<Visita> buscarVisitasAbertasCliente(@Param("idCliente") long idCliente, 
			@Param("idUsuario") long idUsuario, @Param("cidade") String cidade, 
			@Param("estado") String estado, @Param("mes") int mes, @Param("ano") int ano);
	
	@Query("SELECT v"
			+ " FROM Visita v JOIN v.usuario u JOIN v.cliente c"
			+ " WHERE (c.id = :idCliente"
			+ " AND u.id = :idUsuario"
			+ " AND c.cidade LIKE CONCAT('%',:cidade,'%')"
			+ " AND c.estado LIKE CONCAT('%',:estado,'%')"
			+ " AND date_part('month', v.dataPlanejada) = :mes"
			+ " AND date_part('year', v.dataPlanejada) = :ano)"
			+ " OR (c.id = :idCliente"
			+ " AND u.id = :idUsuario"
			+ " AND c.cidade LIKE CONCAT('%',:cidade,'%')"
			+ " AND c.estado LIKE CONCAT('%',:estado,'%')"
			+ " AND date_part('month', v.dataFechamento) = :mes"
			+ " AND date_part('year', v.dataFechamento) = :ano)"
			+ " ORDER BY v.dataPlanejada ASC")
	public List<Visita> buscarTodasVisitasCliente(@Param("idCliente") long idCliente, 
			@Param("idUsuario") long idUsuario, @Param("cidade") String cidade, 
			@Param("estado") String estado, @Param("mes") int mes, @Param("ano") int ano);
	
	@Query("SELECT v"
			+ " FROM Visita v JOIN v.usuario u JOIN v.cliente c"
			+ " WHERE (u.id = :idUsuario"
			+ " AND c.cidade LIKE CONCAT('%',:cidade,'%')"
			+ " AND c.estado LIKE CONCAT('%',:estado,'%')"
			+ " AND date_part('month', v.dataPlanejada) = :mes"
			+ " AND date_part('year', v.dataPlanejada) = :ano)"
			+ " OR (u.id = :idUsuario"
			+ " AND c.cidade LIKE CONCAT('%',:cidade,'%')"
			+ " AND c.estado LIKE CONCAT('%',:estado,'%')"
			+ " AND date_part('month', v.dataFechamento) = :mes"
			+ " AND date_part('year', v.dataFechamento) = :ano)"
			+ " ORDER BY v.dataPlanejada ASC")
	public List<Visita> buscarTodasVisitasTodosClientes(@Param("idUsuario") long idUsuario, 
			@Param("cidade") String cidade, @Param("estado") String estado,
			@Param("mes") int mes, @Param("ano") int ano);
}
