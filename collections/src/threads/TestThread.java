package threads;

import tester.Test;
import tester.TestResult;

public class TestThread implements Runnable {

	private Test test;
	
	public TestThread(Test t){
		test = t;
	}
	
	@Override
	public void run() {

		TestResult tr = new TestResult(test.getCollectionName());
		tr.setInitTime(test.creationTest());
		tr.setFillTime(test.fillTest());
		tr.setSortTime(test.sortTest());
		tr.setAccessTime(test.accessTest(3000));
		tr.setDeletionTime(test.deletionTest(2500, 3900));
		tr.setDuplicateEliminationTime(test.removeDuplicates());
		tr.writeToFile();	
	}

}
