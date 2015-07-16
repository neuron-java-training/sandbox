package hu.neuron.java.project.business;

import java.util.List;

public interface BusinessO {

	Long save(DataBVO dataVO);

	void update(DataBVO dataVO);

	void delete(Long id);

	DataBVO findById(Long id);

	List<DataBVO> findAll();
}
