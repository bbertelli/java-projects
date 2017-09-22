package br.com.atmdigital.crmapi.service;

import br.com.atmdigital.crmapi.common.service.IService;
import br.com.atmdigital.crmapi.model.Usuario;

public interface UsuarioService extends IService<Usuario,Long> {

	public Usuario buscarUsuario(String usuario, String senha);
	
	public Usuario buscarUsuarioPorToken(String token);
}
