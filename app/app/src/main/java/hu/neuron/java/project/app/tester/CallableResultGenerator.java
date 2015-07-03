package hu.neuron.java.project.app.tester;

import java.util.concurrent.Callable;

import hu.neuron.java.project.core.TestResult;


public class CallableResultGenerator implements Callable<TestResult> {

	private Test test;
	
	public CallableResultGenerator(Test t){
		test = t;
	}
	
	@Override
	public TestResult call() {
		TestResult tr = new TestResult(test.getCollectionName());
		tr.setInitTime(test.creationTest());
		tr.setFillTime(test.fillTest());
		tr.setSortTime(test.sortTest());
		tr.setAccessTime(test.accessTest(3000));
		tr.setDeletionTime(test.deletionTest(2500, 3900));
		tr.setDuplicateEliminationTime(test.removeDuplicates());
		return tr;
	}

}
