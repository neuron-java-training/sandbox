package hu.neuron.java.persistence.dao;

import hu.neuron.java.persistence.dto.ResultDTO;

import java.util.List;

public interface ResultDAO extends BaseDAO<ResultDTO>{
	
public Long save(ResultDTO dto) throws Exception;
	
	public void update(ResultDTO dto) throws Exception;
	
	public void delete(Long id) throws Exception;
	
	public ResultDTO find(Long id) throws Exception;
	
	public List<ResultDTO> findAll() throws Exception;
	
	public List<ResultDTO> getAverages() throws Exception;

}
