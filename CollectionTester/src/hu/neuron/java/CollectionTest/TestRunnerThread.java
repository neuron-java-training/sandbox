package hu.neuron.java.CollectionTest;

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
		this.result.setInitTime(tester.init(Tester.LIST_SIZE));
		this.result.setAccessTime(tester.get(Tester.TEST_SIZE));
		this.result.setDeleteTime(tester.delete(Tester.TEST_SIZE));
		try {
			this.result.setSortTime(tester.sort());
		} catch (UnsupportedOperationException ex) {
			this.result.setSortTime(-1);
		}
	}

}
