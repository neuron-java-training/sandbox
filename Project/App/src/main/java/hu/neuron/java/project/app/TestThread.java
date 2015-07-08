package hu.neuron.java.project.app;

import hu.neuron.java.project.common.CollectionSInterface;
import hu.neuron.java.project.core.FileWriterS;
import hu.neuron.java.project.core.TestResult;

public class TestThread<T extends CollectionSInterface> implements Runnable {

	private TestResult testResult = new TestResult("name");
	private T t;
	long timer = 0;
	int fileCounter;
	FileWriterS fileWriterS = new FileWriterS();
	String pathName = "";

	public TestThread(T t, String name, int fileCounter) {
		// TODO Auto-generated constructor stub
		this.t = t;
		testResult.setName(name);
		this.fileCounter = fileCounter;
		pathName = ("result//test" + fileCounter + name + ".txt");
	}

	public void run() {
		fileWriterS.writeFile(pathName, true, "init muvelet eredmenye: ");
		timer = System.nanoTime();
		t.init();
		testResult.setInitTime(System.nanoTime() - timer);
		fileWriterS.writeFile(pathName, true, t.getDatas());

		fileWriterS.writeFile(pathName, true, ("sorting muvelet eredmenye: "));
		timer = System.nanoTime();
		t.sorting();
		testResult.setSortingTime(System.nanoTime() - timer);
		fileWriterS.writeFile(pathName, true, t.getDatas());
		
		fileWriterS.writeFile(pathName, true, ("getItem(10) muvelet eredmenye: "));
		timer = System.nanoTime();
		fileWriterS.writeFile(pathName, true, t.getItem(10));
		testResult.setGetItemTime(System.nanoTime() - timer);

		fileWriterS.writeFile(pathName, true, ("deleteItemsByRange(10, 15) muvelet eredmenye: "));
		timer = System.nanoTime();
		t.deleteItemsByRange(10, 15);
		testResult.setDeleteItemsByRangeTime(System.nanoTime() - timer);
		fileWriterS.writeFile(pathName, true, t.getDatas());

		fileWriterS.writeFile(pathName, true, ("duplicationClear muvelet eredmenye: "));
		timer = System.nanoTime();
		t.duplicationClear();
		testResult.setDuplicationClearTime(System.nanoTime() - timer);
		fileWriterS.writeFile(pathName, true, t.getDatas());

		fileWriterS.writeFile(
				("result//test" + fileCounter + "result.txt"),
				true,
				(testResult.getName() + " ->|initTime-> " + (double) testResult.getInitTime()
						/ 1_000_000 + " ms|sortingTime-> " + (double) testResult.getSortingTime()
						/ 1_000_000 + " ms|getItemTime-> " + (double) testResult.getGetItemTime()
						/ 1_000_000 + " ms|deleteItemsByRangeTime-> "
						+ (double) testResult.getDeleteItemsByRangeTime() / 1_000_000
						+ " ms|duplicationClearTime-> "
						+ (double) testResult.getDuplicationClearTime() / 1_000_000 + " ms|"));
	}
}
