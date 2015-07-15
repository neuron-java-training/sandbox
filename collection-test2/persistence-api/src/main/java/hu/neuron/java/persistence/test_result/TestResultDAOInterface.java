package hu.neuron.java.persistence.test_result;

import java.util.List;

public interface TestResultDAOInterface {

	public Long save(TestResultDTO dto) throws Exception;
	
	public void update(TestResultDTO dto) throws Exception;
	
	public void delete(Long id) throws Exception;
	
	public TestResultDTO find(Long id) throws Exception;
	
	public List<TestResultDTO> findAll() throws Exception;
	
	public List<TestResultDTO> getAverages() throws Exception;
	
}
