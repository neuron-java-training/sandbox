package hu.neuron.java.project.core.db;

import hu.neuron.java.project.core.entity.BaseEntity;
import java.io.Serializable;
import java.util.List;

public interface BaseDAO<E extends BaseEntity, D extends Serializable> {

	public Long save(D dto) throws Exception;

	public void update(D dto) throws Exception;

	public void delete(Long id) throws Exception;

	public D find(Long id) throws Exception;

	public List<D> findAll() throws Exception;

	E toEntity(D vo, E entity);
	
	D toVo(E entity);

	public E findEntity(Long userId) throws Exception;

	public Long saveEntity(E user) throws Exception;

}
