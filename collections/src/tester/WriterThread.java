package tester;

import interfaces.Writer;

public class WriterThread implements Runnable {

	private Test test;
	Writer writer;
	
	public WriterThread(Test t, Writer w){
		test = t;
		writer = w;
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
		writer.write(tr);
	}

}
