package hu.neuron.java.project.core.dao;

import hu.neuron.java.project.core.entity.BaseEntity;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseDaoImpl<E extends BaseEntity, V extends Serializable>
		implements BaseDAO<E,V> {

	@PersistenceContext
	protected EntityManager entityManager;

	protected Class<E> entityClass;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass
				.getActualTypeArguments()[0];
	}

	@Override
	public Long save(V vo) throws Exception {
		return saveEntity(toEntity(vo, null));
	}

	@Override
	public void update(V vo) throws Exception {
		E entity = toEntity(vo, null);
		this.updateEntity(entity);

	}

	@Override
	public void delete(Long id) throws Exception {
		deleteEntity(id);
	}

	@Override
	public V find(Long id) throws Exception {
		return toVo(findEntity(id));
	}

	@Override
	public List<V> findAll() throws Exception {
		List<E> resultList = findAllEntity();
		List<V> rv = new ArrayList<V>();
		for (E e : resultList) {
			rv.add(toVo(e));
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
