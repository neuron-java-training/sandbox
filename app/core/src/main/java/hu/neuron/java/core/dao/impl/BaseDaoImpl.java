package hu.neuron.java.core.dao.impl;

import hu.neuron.java.common.dao.BaseDao;
import hu.neuron.java.core.entity.BaseEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseDaoImpl<E extends BaseEntity, D extends Serializable>
		implements BaseDao<D> {

	@PersistenceContext
	protected EntityManager entityManager;

	protected Class<E> entityClass;

	public BaseDaoImpl(Class<E> entityClass) {
		this.entityClass = entityClass;

	}

	@Override
	public Long save(D dto) throws Exception {
		return saveEntity((E) toEntity(dto, null));
	}

	@Override
	public void update(D dto) throws Exception {
		E entity = (E) toEntity(dto, null);
		this.updateEntity(entity);

	}

	@Override
	public void delete(Long id) throws Exception {
		deleteEntity(id);
	}

	@Override
	public D find(Long id) throws Exception {
		return toDto(findEntity(id));
	}

	@Override
	public List<D> findAll() throws Exception {
		List<E> resultList = findAllEntity();
		List<D> rv = new ArrayList<D>();
		for (E e : resultList) {
			rv.add(toDto(e));
		}
		return rv;
	}

	public Long saveEntity(E entity) throws Exception {
		entityManager.persist(entity);
		return entity.getId();
	}

	public void updateEntity(E entity) throws Exception {
		this.entityManager.merge(entity);

	}

	public void deleteEntity(Long id) throws Exception {
		E e = this.entityManager.find(entityClass, id);
		this.entityManager.remove(e);

	}

	public E findEntity(Long id) throws Exception {
		return this.entityManager.find(entityClass, id);

	}

	@SuppressWarnings("unchecked")
	public List<E> findAllEntity() throws Exception {

		return entityManager.createQuery(
				"Select t from " + entityClass.getSimpleName() + " t")
				.getResultList();
	}

}
