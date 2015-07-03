package app.test_runner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import common.collection_test.Tester;
import common.collection_test.runner.TestRunnerInterface;
import core.test_result.TestResult;

public class TestRunner implements TestRunnerInterface{

	private List<Tester> testList = null;
	private List<TestResult> resultList = null;

	public TestRunner() {
		super();
		this.testList = new ArrayList<>();
		this.resultList = new ArrayList<>();
	}

	@Override
	public void addTest(Tester tester){
		this.testList.add(tester);
	}
	
	@Override
	public List<TestResult> runAllTest(){
		resultList.clear();
		
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		
		for (Tester tester : testList) {
			Future<TestResult> future = executorService.submit(new TestRunnerThread(tester));
			try {
				resultList.add(future.get());
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
		executorService.shutdown();
		return resultList;
	}

	@Override
	public List<TestResult> getResultList() {
		return resultList;
	}
	
	@Override
	public String toString() {
		String result = "";
		for (TestResult r : resultList) {
			result += r + "\n";
		}
		return result;
	}	
	
}
