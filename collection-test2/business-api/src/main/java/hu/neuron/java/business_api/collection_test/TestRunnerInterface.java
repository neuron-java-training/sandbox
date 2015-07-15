package hu.neuron.java.business_api.collection_test;

import java.util.List;

public interface TestRunnerInterface {

	public void addTest(Tester tester);

	public List<TestResult> runAllTest();

	public List<TestResult> getResultList();

}
