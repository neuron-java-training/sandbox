package hu.neuron.java.business_api.collection_test;

import hu.neuron.java.service.vo.ResultVO;

import java.util.List;

public interface TestRunnerInterface {

	public void addTest(Tester tester);

	public List<ResultVO> runAllTest();

	public List<ResultVO> getResultList();

}
