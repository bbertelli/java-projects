package br.com.atmdigital.crmapi.service;

import java.util.List;

import br.com.atmdigital.crmapi.common.service.IService;
import br.com.atmdigital.crmapi.model.ClienteUsuario;


public interface ClienteUsuarioService extends IService<ClienteUsuario,Long>{
	
	public List<ClienteUsuario> buscarClientesPorIdUsuario(long idUsuario);
	
	public List<ClienteUsuario> buscarClientesFavoritos(long idUsuario);
	
	public List<ClienteUsuario> buscarClientesPorFiltros(String nome, String cidade, String estado, long idUsuario);
	
	public List<ClienteUsuario> buscarClientesPorInicial(String letraInicial, String cidade, String estado, long idUsuario);
	
	public ClienteUsuario getInfoCliente(long idCliente, long idUsuario);
	
	public void salvarFavorito(long idCliente, long idUsuario);
	
	public void removerFavorito(long idCliente, long idUsuario);
}
