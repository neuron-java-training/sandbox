package neuron4ora.feladatCollections2;

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
		try (PrintWriter output = new PrintWriter(new FileWriter("test" + fileCounter
				+ testResult.getName() + ".txt", true))) {
			output.println("init muvelet eredmenye: ");
		} catch (Exception e) {
		}
		timer = System.nanoTime();
		t.init();
		testResult.setInitTime(System.nanoTime() - timer);
		try (PrintWriter output = new PrintWriter(new FileWriter("test" + fileCounter
				+ testResult.getName() + ".txt", true))) {
			output.println(t.getDatas());
		} catch (Exception e) {
		}

		try (PrintWriter output = new PrintWriter(new FileWriter("test" + fileCounter
				+ testResult.getName() + ".txt", true))) {
			output.println("getItem(10) muvelet eredmenye: ");
		} catch (Exception e) {
		}
		timer = System.nanoTime();
		try (PrintWriter output = new PrintWriter(new FileWriter("test" + fileCounter
				+ testResult.getName() + ".txt", true))) {
			output.println(t.getItem(10));
		} catch (Exception e) {
		}
		testResult.setGetItemTime(System.nanoTime() - timer);

		try (PrintWriter output = new PrintWriter(new FileWriter("test" + fileCounter
				+ testResult.getName() + ".txt", true))) {
			output.println("sorting muvelet eredmenye: ");
		} catch (Exception e) {
		}
		timer = System.nanoTime();
		t.sorting();
		testResult.setSortingTime(System.nanoTime() - timer);
		try (PrintWriter output = new PrintWriter(new FileWriter("test" + fileCounter
				+ testResult.getName() + ".txt", true))) {
			output.println(t.getDatas());
		} catch (Exception e) {
		}

		try (PrintWriter output = new PrintWriter(new FileWriter("test" + fileCounter
				+ testResult.getName() + ".txt", true))) {
			output.println("deleteItemsByRange(10, 15) muvelet eredmenye: ");
		} catch (Exception e) {
		}
		timer = System.nanoTime();
		t.deleteItemsByRange(10, 15);
		testResult.setDeleteItemsByRangeTime(System.nanoTime() - timer);
		try (PrintWriter output = new PrintWriter(new FileWriter("test" + fileCounter
				+ testResult.getName() + ".txt", true))) {
			output.println(t.getDatas());
		} catch (Exception e) {
		}

		try (PrintWriter output = new PrintWriter(new FileWriter("test" + fileCounter
				+ testResult.getName() + ".txt", true))) {
			output.println("duplicationClear muvelet eredmenye: ");
		} catch (Exception e) {
		}
		timer = System.nanoTime();
		t.duplicationClear();
		testResult.setDuplicationClearTime(System.nanoTime() - timer);
		try (PrintWriter output = new PrintWriter(new FileWriter("test" + fileCounter
				+ testResult.getName() + ".txt", true))) {
			output.println(t.getDatas());
		} catch (Exception e) {
		}

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
}
