package collectionsComparation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestRunner {

	static final long db = 5_000_000;
	static final int getE = 1177, const2 = 270, const3 = 300, allTest = 5;

	public TestResults TimeCounter() {

		List<ListItems> t = new LinkedList<>();

		ListTest<List<ListItems>> listTest = new ListTest<>();

		long diff1 = 0, diff2 = 0, a, b;

		a = System.nanoTime();
		listTest.init(t);
		listTest.order();
		listTest.getElement(getE);
		listTest.delete(const2, const3);
		b = System.nanoTime();
		diff1 = b - a;

		t = new ArrayList<>();

		a = System.nanoTime();
		listTest.init(t);
		listTest.order();
		listTest.getElement(getE);
		listTest.delete(const2, const3);
		b = System.nanoTime();
		diff2 = b - a;

		return new TestResults(diff1, diff2, db);
	}

	public static void main(String[] args) {

		TestRunner testrunner = new TestRunner();
		IO io = new IO();

		for (int i = 0; i < allTest; i++) {

			String fileName = ("testResult" + i);
			TestResults testresults = testrunner.TimeCounter();

			io.delete(fileName);
			io.write(testresults, fileName);
			io.read(fileName);
		}

		System.out.println("LinkedList Average on " + allTest + " tests: " + io.getSum1() / allTest + " nanosecond");

		System.out.println("ArrayList Average on " + allTest + " tests: " + io.getSum2() / allTest + " nanosecond");

	}

}
