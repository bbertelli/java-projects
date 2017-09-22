/*
 * 1.1
 */
package br.com.atmdigital.crmapi.common.dao;


import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import br.com.atmdigital.crmapi.common.model.IIdentified;



/**
 * 
 * @author Bruno Bertelli
 *
 * @param <E>
 * @param <ID>
 */
@NoRepositoryBean
public interface AbstractDao<E extends IIdentified<ID>, ID extends Serializable> extends JpaRepository<E, ID> {

	
}
