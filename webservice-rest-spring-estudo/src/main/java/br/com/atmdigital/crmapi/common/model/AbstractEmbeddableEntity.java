
package br.com.atmdigital.crmapi.common.model;

import javax.persistence.MappedSuperclass;

/**
 * 
 * @author Bruno Bertelli
 *
 * @param <ID>
 */
@MappedSuperclass
public abstract class AbstractEmbeddableEntity<ID> implements IIdentified<ID>{
	
	private static final long serialVersionUID = 1L;
	
	public abstract void buildEmbeddedId();
	
}