package hu.neuron.java.project.core.dao;

import java.util.List;

import hu.neuron.java.project.core.TestResult;
import hu.neuron.java.project.core.vo.TestResultVO;

public interface TestResultDAO {
	
	public Long save(TestResult tr);
	public List<TestResultVO> readAll();

}
