package hu.neuron.java.project.app;

import hu.neuron.java.project.common.TestInterface;
import hu.neuron.java.project.core.TestResult;

import java.io.FileWriter;
import java.io.PrintWriter;

public class TestThread<T extends TestInterface> implements Runnable {

	private TestResult testResult = new TestResult("name");
	private T t;
	long timer = 0;
	int fileCounter;

	public TestThread(T t, String name, int fileCounter) {
		// TODO Auto-generated constructor stub
		this.t = t;
		testResult.setName(name);
		this.fileCounter = fileCounter;
	}

	public void run() {	
		writer("init muvelet eredmenye: ");
		timer = System.nanoTime();
		t.init();
		testResult.setInitTime(System.nanoTime() - timer);
		writer(t.getDatas());

		writer("getItem(10) muvelet eredmenye: ");
		timer = System.nanoTime();
		writer(t.getItem(10));
		testResult.setGetItemTime(System.nanoTime() - timer);

		writer("sorting muvelet eredmenye: ");
		timer = System.nanoTime();
		t.sorting();
		testResult.setSortingTime(System.nanoTime() - timer);
		writer(t.getDatas());

		writer("deleteItemsByRange(10, 15) muvelet eredmenye: ");
		timer = System.nanoTime();
		t.deleteItemsByRange(10, 15);
		testResult.setDeleteItemsByRangeTime(System.nanoTime() - timer);
		writer(t.getDatas());

		writer("duplicationClear muvelet eredmenye: ");
		timer = System.nanoTime();
		t.duplicationClear();
		testResult.setDuplicationClearTime(System.nanoTime() - timer);
		writer(t.getDatas());

		try (PrintWriter output = new PrintWriter(new FileWriter("test" + fileCounter
				+ "result.txt", true))) {
			output.println(testResult.getName() + ": initTime->"
					+ (double) testResult.getInitTime() / 1_000_000 + " ms |sortingTime->"
					+ (double) testResult.getSortingTime() / 1_000_000 + " ms |getItemTime->"
					+ (double) testResult.getGetItemTime() / 1_000_000
					+ " ms |deleteItemsByRangeTime->"
					+ (double) testResult.getDeleteItemsByRangeTime() / 1_000_000
					+ " ms |duplicationClearTime->" + (double) testResult.getDuplicationClearTime()
					/ 1_000_000+" ms");
		} catch (Exception e) {
		}
	}
	
	private void writer(Object text){
		try (PrintWriter output = new PrintWriter(new FileWriter("test" + fileCounter
				+ testResult.getName() + ".txt", true))) {
			output.println(text);
		} catch (Exception e) {
		}
	}
}
