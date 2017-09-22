package br.com.atmdigital.crmapi.service.impl;

import javax.transaction.NotSupportedException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.atmdigital.crmapi.common.service.AbstractEntityServiceImpl;
import br.com.atmdigital.crmapi.dao.UsuarioDao;
import br.com.atmdigital.crmapi.model.Usuario;
import br.com.atmdigital.crmapi.service.UsuarioService;
import lombok.Getter;
import lombok.Setter;

@Service
@Transactional
@Getter @Setter
public class UsuarioServiceImpl extends AbstractEntityServiceImpl<Usuario,UsuarioDao,Long> implements UsuarioService{

	@Override
	public Usuario save(Usuario entity) throws Exception {
		return getDao().save(entity);
	}
	
	@Override
	public void delete(Usuario entity) throws Exception {
		throw new NotSupportedException();
	}

	@Override
	public Usuario buscarUsuario(String usuario, String senha) {
		return getDao().buscarUsuario(usuario, senha);
	}
	
	public Usuario buscarUsuarioPorToken(String token) {
		return getDao().buscarUsuarioPorToken(token);
	}
}
