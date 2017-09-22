package br.com.atmdigital.crmapi.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.atmdigital.crmapi.common.dao.AbstractDao;
import br.com.atmdigital.crmapi.model.Usuario;

@Repository
public interface UsuarioDao extends AbstractDao<Usuario, Long>{
	
	@Query("SELECT u"
    		+ " FROM Usuario u"
    		+ " WHERE u.usuario = :usuario"
    		+ " AND u.senha = :senha")
    public Usuario buscarUsuario(@Param("usuario") String usuario, 
    		@Param("senha") String senha);
	
	@Query("SELECT u"
    		+ " FROM Usuario u"
    		+ " WHERE u.token = :token")
    public Usuario buscarUsuarioPorToken(@Param("token") String token);
}
