package hu.neuron.java.persistence.dao.impl;

import hu.neuron.java.persistence.dao.BaseDAO;
import hu.neuron.java.persistence.entity.BaseEntity;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseDaoImpl<E extends BaseEntity, D extends Serializable> implements BaseConvertDao<E, D>, BaseDAO<D> {

	@PersistenceContext
	protected EntityManager entityManager;

	protected Class<E> entityClass;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
	}

	@Override
	public Long save(D dto) throws Exception {
		return saveEntity(toEntity(dto, null));
	}

	@Override
	public void update(D dto) throws Exception {
		E entity = toEntity(dto, null);
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

	@Override
	public Long saveEntity(E entity) throws Exception {
		entityManager.persist(entity);
		return entity.getId();
	}

	@Override
	public void updateEntity(E entity) throws Exception {
		this.entityManager.merge(entity);

	}

	@Override
	public void deleteEntity(Long id) throws Exception {
		E e = this.entityManager.find(entityClass, id);
		this.entityManager.remove(e);

	}

	@Override
	public E findEntity(Long id) throws Exception {
		return this.entityManager.find(entityClass, id);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> findAllEntity() throws Exception {

		return entityManager.createQuery("Select t from " + entityClass.getSimpleName() + " t").getResultList();
	}

}
