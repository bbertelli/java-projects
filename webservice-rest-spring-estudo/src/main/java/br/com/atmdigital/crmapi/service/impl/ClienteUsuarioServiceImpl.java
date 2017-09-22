package br.com.atmdigital.crmapi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.atmdigital.crmapi.common.service.AbstractEntityServiceImpl;
import br.com.atmdigital.crmapi.dao.ClienteUsuarioDao;
import br.com.atmdigital.crmapi.model.ClienteUsuario;
import br.com.atmdigital.crmapi.service.ClienteUsuarioService;
import lombok.Getter;
import lombok.Setter;

@Service
@Transactional
@Getter @Setter
public class ClienteUsuarioServiceImpl extends AbstractEntityServiceImpl<ClienteUsuario,ClienteUsuarioDao,Long> implements ClienteUsuarioService{

	@Override
	public ClienteUsuario save(ClienteUsuario entity) throws Exception {
		return getDao().save(entity);
	}
	
	@Override
	public void delete(ClienteUsuario entity) throws Exception {
		getDao().delete(entity);
	}
	
	public List<ClienteUsuario> buscarClientesPorIdUsuario(long idUsuario) {
		return getDao().buscarClientesPorIdUsuario(idUsuario);
	}
	
	public List<ClienteUsuario> buscarClientesFavoritos(long idUsuario){
		return getDao().buscarClientesFavoritos(idUsuario);
	}
	
	public List<ClienteUsuario> buscarClientesPorFiltros(String nome, String cidade, String estado, long idUsuario){
		return getDao().buscarClientesPorFiltros(nome, cidade, estado, idUsuario);
	}

	public List<ClienteUsuario> buscarClientesPorInicial(String letraInicial, String cidade, String estado, long idUsuario){
		return getDao().buscarClientesPorInicial(letraInicial, cidade, estado, idUsuario);
	}
	
	public ClienteUsuario getInfoCliente(long idCliente, long idUsuario) {
		return getDao().getInfoCliente(idCliente,idUsuario);
	}
	
	public void salvarFavorito(long idCliente, long idUsuario) {
		getDao().salvarFavorito(idCliente, idUsuario);
	}
	
	public void removerFavorito(long idCliente, long idUsuario) {
		getDao().removerFavorito(idCliente, idUsuario);
	}
}
