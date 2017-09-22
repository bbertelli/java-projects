package br.com.atmdigital.crmapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.atmdigital.crmapi.common.dao.AbstractDao;
import br.com.atmdigital.crmapi.model.ClienteUsuario;

@Repository
public interface ClienteUsuarioDao extends AbstractDao<ClienteUsuario, Long>{
	
	@Query("SELECT c"
			+ " FROM ClienteUsuario c JOIN c.usuario u JOIN c.cliente cli"
			+ " WHERE u.id = :idUsuario"
			+ " AND cli.ativo = 1"
			+ " AND u.ativo = 1"
			+ " ORDER BY cli.nome")
	public List<ClienteUsuario> buscarClientesPorIdUsuario(@Param("idUsuario") long idUsuario);
	
	@Query("SELECT c"
			+ " FROM ClienteUsuario c JOIN c.usuario u JOIN c.cliente cli"
			+ " WHERE u.id = :idUsuario"
			+ " AND c.favorito = 1"
			+ " AND cli.ativo = 1"
			+ " AND u.ativo = 1"
			+ " ORDER BY cli.nome")
	public List<ClienteUsuario> buscarClientesFavoritos(@Param("idUsuario") long idUsuario);
	
	@Query("SELECT c"
			+ " FROM ClienteUsuario c JOIN c.usuario u JOIN c.cliente cli"
			+ " WHERE cli.nome LIKE CONCAT('%',:nome,'%')"
			+ " AND cli.cidade LIKE CONCAT('%',:cidade,'%')"
			+ " AND cli.estado LIKE CONCAT('%',:estado,'%')"
			+ " AND u.id = :idUsuario"
			+ " AND cli.ativo = 1"
			+ " AND u.ativo = 1"
			+ " ORDER BY cli.nome")
	public List<ClienteUsuario> buscarClientesPorFiltros(@Param("nome") String nome, 
			@Param("cidade") String cidade, @Param("estado") String estado,
			@Param("idUsuario") long idUsuario);
	
	@Query("SELECT c"
			+ " FROM ClienteUsuario c JOIN c.usuario u JOIN c.cliente cli"
			+ " WHERE cli.nome LIKE CONCAT(:letraInicial,'%')"
			+ " AND cli.cidade LIKE CONCAT('%',:cidade,'%')"
			+ " AND cli.estado LIKE CONCAT('%',:estado,'%')"
			+ " AND u.id = :idUsuario"
			+ " AND cli.ativo = 1"
			+ " AND u.ativo = 1"
			+ " ORDER BY cli.nome")
	public List<ClienteUsuario> buscarClientesPorInicial(@Param("letraInicial") String letraInicial, 
			@Param("cidade") String cidade, @Param("estado") String estado,
			@Param("idUsuario") long idUsuario);
	
	@Query("SELECT c"
			+ " FROM ClienteUsuario c JOIN c.usuario u JOIN c.cliente cli"
			+ " WHERE cli.id = :idCliente"
			+ " AND cli.ativo = 1"
			+ " AND u.ativo = 1"
			+ " AND u.id = :idUsuario")
	public ClienteUsuario getInfoCliente(@Param("idCliente") long idCliente, @Param("idUsuario") long idUsuario);
	
	@Modifying
	@Query("UPDATE ClienteUsuario c"
			+ " SET c.favorito = 1"
			+ " WHERE EXISTS (SELECT a"
			+ " FROM ClienteUsuario a JOIN a.usuario u JOIN a.cliente cli"
			+ " WHERE cli.id = :idCliente"
			+ " AND cli.ativo = 1"
			+ " AND u.ativo = 1"
			+ " AND u.id = :idUsuario and a.id = c.id)")
	public void salvarFavorito(@Param("idCliente") long idCliente, @Param("idUsuario") long idUsuario);
	
	@Modifying
	@Query("UPDATE ClienteUsuario c"
			+ " SET c.favorito = 0"
			+ " WHERE EXISTS (SELECT a"
			+ " FROM ClienteUsuario a JOIN a.usuario u JOIN a.cliente cli"
			+ " WHERE cli.id = :idCliente"
			+ " AND cli.ativo = 1"
			+ " AND u.ativo = 1"
			+ " AND u.id = :idUsuario and a.id = c.id)")
	public void removerFavorito(@Param("idCliente") long idCliente, @Param("idUsuario") long idUsuario);
}
