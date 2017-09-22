package br.com.atmdigital.crmapi.service;

import java.util.List;

import br.com.atmdigital.crmapi.common.service.IService;
import br.com.atmdigital.crmapi.model.Cliente;
import br.com.atmdigital.crmapi.model.Usuario;


public interface ClienteService extends IService<Cliente,Long>{
	
	public List<Cliente> buscarClientesSemVisitas(long idUsuario, int qtdDias);
	
	public void registrarNovoCliente(Cliente cliente, Usuario usuario, int favorito) throws Exception;
	
}
