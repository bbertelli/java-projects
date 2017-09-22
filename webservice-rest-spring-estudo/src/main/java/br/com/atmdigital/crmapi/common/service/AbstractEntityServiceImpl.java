package br.com.atmdigital.crmapi.common.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.NotSupportedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import br.com.atmdigital.crmapi.common.dao.AbstractDao;
import br.com.atmdigital.crmapi.common.model.IIdentified;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Bruno Bertelli
 *
 * @param <E>
 * @param <D>
 * @param <ID>
 */
@Getter @Setter
public abstract class AbstractEntityServiceImpl<E extends IIdentified<ID>, D extends AbstractDao<E, ID>, ID extends Serializable>
		 extends AbstractServiceImpl implements IService<E, ID> {

	/**
	 * Classe utilizado para manutenção para <E>.
	 */
	@Autowired
	private D dao;

	/**
	 * Classe que representa entidade <E>.
	 */
	private Class<E> entityClass;


	/**
	 * Cria uma instancia de AbstractServiceBean.
	 */
	@SuppressWarnings("unchecked")
	public AbstractEntityServiceImpl() {
		this.entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	/**
	 * @return Class<E>
	 */
	public final Class<E> getEntityClass() {
		return entityClass;
	}

	/**
	 * 
	 * @param entityClass <E>
	 */
	public final void setEntityClass(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	/**
	 * {@inheritDoc}
	 */
	public final E findOne(final ID id) {
		return dao.findOne(id);
	}

	/**
	 * @return List<E>
	 */
	public final List<E> findAll() {
		return dao.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	public E save(E entity) throws Exception {
		throw new NotSupportedException();
	}

	/**
	 * Deleta um produto
	 */
	public void delete(E entity) throws Exception  {
		throw new NotSupportedException();
	}

	public List<E> findAll(int page, int pageSize) {
		Pageable limit = new PageRequest(page, pageSize);
		Page<E> result = this.dao.findAll(limit);
		List<E> newResult = new ArrayList<E>();
		;

		for (Iterator<E> iterator = result.iterator(); iterator.hasNext();) {
			newResult.add((E) iterator.next());
		}

		return newResult;
	}
	
	

}
