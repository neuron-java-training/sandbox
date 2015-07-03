package hu.neuron.java.project.app.tester;

import hu.neuron.java.project.common.interfaces.Writer;
import hu.neuron.java.project.core.FileWriter;
import hu.neuron.java.project.core.TestResult;


public class WriterThread implements Runnable {

	private Test test;
	Writer writer;
	
	public WriterThread(Test t){
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
		(new FileWriter(tr)).write();
	}

}
