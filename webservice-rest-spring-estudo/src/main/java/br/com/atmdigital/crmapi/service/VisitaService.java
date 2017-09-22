package br.com.atmdigital.crmapi.service;

import java.util.List;

import br.com.atmdigital.crmapi.common.service.IService;
import br.com.atmdigital.crmapi.model.Visita;


public interface VisitaService extends IService<Visita,Long>{
	
	public List<Visita> buscarVisitasFechadasTodosClientes(long idUsuario, String cidade, 
			String estado, int mes, int ano);
	
	public List<Visita> buscarVisitasFechadasCliente(long idCliente, long idUsuario, 
		String cidade, String estado, int mes, int ano);
	
	public List<Visita> buscarVisitasAbertasTodosClientes(long idUsuario, String cidade, 
			String estado, int mes, int ano);
	
	public List<Visita> buscarVisitasAbertasCliente(long idCliente, long idUsuario, 
			String cidade, String estado, int mes, int ano);
	
	public List<Visita> buscarTodasVisitasCliente(long idCliente, long idUsuario, 
			String cidade, String estado, int mes, int ano);
	
	public List<Visita> buscarTodasVisitasTodosClientes(long idUsuario, String cidade, 
			String estado, int mes, int ano);
}
