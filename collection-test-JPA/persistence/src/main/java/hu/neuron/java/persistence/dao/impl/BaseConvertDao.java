package hu.neuron.java.persistence.dao.impl;

import hu.neuron.java.persistence.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseConvertDao<E extends BaseEntity, D extends Serializable> {

	E toEntity(D dto, E entity);

	D toDto(E entity);

	public Long saveEntity(E entity) throws Exception;

	public void updateEntity(E entity) throws Exception;

	public void deleteEntity(Long id) throws Exception;

	public E findEntity(Long id) throws Exception;

	public List<E> findAllEntity() throws Exception;
}
