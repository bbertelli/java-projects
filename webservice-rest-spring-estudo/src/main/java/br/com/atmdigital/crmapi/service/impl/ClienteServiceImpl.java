package br.com.atmdigital.crmapi.service.impl;

import java.util.List;

import javax.transaction.NotSupportedException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atmdigital.crmapi.common.service.AbstractEntityServiceImpl;
import br.com.atmdigital.crmapi.dao.ClienteDao;
import br.com.atmdigital.crmapi.model.Cliente;
import br.com.atmdigital.crmapi.model.ClienteUsuario;
import br.com.atmdigital.crmapi.model.Usuario;
import br.com.atmdigital.crmapi.service.ClienteService;
import br.com.atmdigital.crmapi.service.ClienteUsuarioService;
import lombok.Getter;
import lombok.Setter;

@Service
@Transactional
@Getter @Setter
public class ClienteServiceImpl extends AbstractEntityServiceImpl<Cliente,ClienteDao,Long> implements ClienteService{

	@Autowired
	ClienteUsuarioService clienteUsuarioService;
	
	@Override
	public Cliente save(Cliente entity) throws Exception {
		return getDao().save(entity);
	}
	
	@Override
	public void delete(Cliente entity) throws Exception {
		throw new NotSupportedException();
	}
	
	public void registrarNovoCliente(Cliente cliente, Usuario usuario, int favorito) throws Exception{
		ClienteUsuario clienteUsuario = new ClienteUsuario();
		clienteUsuario.setCliente(cliente);
		clienteUsuario.setUsuario(usuario);
		clienteUsuario.setFavorito(favorito);
		
		this.save(cliente);
		this.clienteUsuarioService.save(clienteUsuario);
		
	}

	
	public void saveClienteAndClienteUsuario(ClienteUsuario clienteUsuario) throws Exception {
		
		this.save(clienteUsuario.getCliente());
		clienteUsuarioService.save(clienteUsuario);		
	}
	
	public List<Cliente> buscarClientesSemVisitas(long idUsuario, int qtdDias){
		return getDao().buscarClientesSemVisitas(idUsuario, qtdDias);
	}
}
