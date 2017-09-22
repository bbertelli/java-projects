package br.com.atmdigital.crmapi.common.service;

import java.util.List;

import br.com.atmdigital.crmapi.common.model.IIdentified;

/**
 * 
 * @author Bruno Bertelli
 *
 * @param <E>
 * @param <ID>
 */
public interface IService<E extends IIdentified<ID>, ID> {
	
	/**
	 * Método utilizado para efetuar consulta por <ID>.
	 * @param id
	 * @return <E>
	 */
	E findOne(ID id);

	/**
	 * Método utilizado para retorn todos os registros para <E>.
	 * @return List<E>
	 */
	List<E> findAll();

	/**
	 * Método utilizado para savar <E>.
	 * 
	 * @param entity
	 * @return <E>
	 */
	E save(E entity) throws Exception;

	/**
	 * Método utilizado para remover <E>.
	 * @param entity
	 * @return <Boolean>
	 */
    void delete(E entity) throws Exception;

}