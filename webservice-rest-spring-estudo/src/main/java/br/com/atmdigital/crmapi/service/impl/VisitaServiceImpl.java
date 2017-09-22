package br.com.atmdigital.crmapi.service.impl;

import java.util.List;

import javax.transaction.NotSupportedException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.atmdigital.crmapi.common.service.AbstractEntityServiceImpl;
import br.com.atmdigital.crmapi.dao.VisitaDao;
import br.com.atmdigital.crmapi.model.Visita;
import br.com.atmdigital.crmapi.service.VisitaService;
import lombok.Getter;
import lombok.Setter;

@Service
@Transactional
@Getter @Setter
public class VisitaServiceImpl extends AbstractEntityServiceImpl<Visita,VisitaDao,Long> implements VisitaService{

	@Override
	public void delete(Visita entity) throws Exception {
		throw new NotSupportedException();
	}

	@Override
	public Visita save(Visita visita) throws Exception {
		
		return getDao().save(visita);
	}
	
	public List<Visita> buscarVisitasFechadasTodosClientes(long idUsuario, String cidade, 
			String estado, int mes, int ano){
		return getDao().buscarVisitasFechadasTodosClientes(idUsuario, cidade, estado, mes, ano);
	}
	
	public List<Visita> buscarVisitasFechadasCliente(long idCliente, long idUsuario, 
		String cidade, String estado, int mes, int ano){
		return getDao().buscarVisitasFechadasCliente(idCliente, idUsuario, cidade, estado, mes, ano);
	}
	
	public List<Visita> buscarVisitasAbertasTodosClientes(long idUsuario, String cidade, 
			String estado, int mes, int ano){
		return getDao().buscarVisitasAbertasTodosClientes(idUsuario, cidade, estado, mes, ano);
	}
	
	public List<Visita> buscarVisitasAbertasCliente(long idCliente, long idUsuario, 
			String cidade, String estado, int mes, int ano){
		return getDao().buscarVisitasAbertasCliente(idCliente, idUsuario, cidade, estado, mes, ano);
	}
	
	public List<Visita> buscarTodasVisitasCliente(long idCliente, long idUsuario, 
			String cidade, String estado, int mes, int ano){
		return getDao().buscarTodasVisitasCliente(idCliente, idUsuario, cidade, estado, mes, ano);
	}
	
	public List<Visita> buscarTodasVisitasTodosClientes(long idUsuario, String cidade, 
			String estado, int mes, int ano){
		return getDao().buscarTodasVisitasTodosClientes(idUsuario, cidade, estado, mes, ano);
	}
}
