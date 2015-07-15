package hu.neuron.java.business.collection_test.testRunner;

import hu.neuron.java.business_api.collection_test.TestResult;
import hu.neuron.java.business_api.collection_test.Tester;

import java.util.concurrent.Callable;


public class TestRunnerThread implements Callable<TestResult>{

	private Tester tester = null;
	private TestResult result = null;
	
	public TestRunnerThread(Tester tester) {
		super();
		this.tester = tester;
		this.result = new TestResult(tester.getTestName());
	}

	@Override
	public TestResult call() throws Exception {
		System.out.println("Run as thread: " + tester.getTestName());
		runTheTest();
		System.out.println("Thread done: " + tester.getTestName());
		return result;
	}
	
	private void runTheTest(){
		this.result.setInitTime(tester.init());
		this.result.setAccessTime(tester.get());
		this.result.setDeleteTime(tester.delete());
		try {
			this.result.setSortTime(tester.sort());
		} catch (UnsupportedOperationException ex) {
			this.result.setSortTime(-1l);
		}
	}
	
}
