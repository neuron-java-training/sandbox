package common.collection_test.runner;

import java.util.List;

import common.collection_test.Tester;
import core.test_result.TestResult;

public interface TestRunnerInterface {

public void addTest(Tester tester);
	
	public List<TestResult> runAllTest();

	public List<TestResult> getResultList();
	
}
