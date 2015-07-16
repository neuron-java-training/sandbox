package hu.neuron.java.project.persistens;

import java.util.List;

public interface DataDao {

	Long save(DataVO dataVO);

	void update(DataVO dataVO);

	void delete(Long id);

	DataVO findById(Long id);

	List<DataVO> findAll();

}
