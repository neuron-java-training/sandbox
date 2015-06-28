package run;

import listtest.ArrayListTest;
import listtest.LinkedListTest;
import settest.HashSetTest;
import settest.TreeSetTest;

public class TestRunner {
	static final int START_INDEX = 0;

	public static void run() {
		new ArrayListTest(START_INDEX);
		new LinkedListTest(START_INDEX);
		new HashSetTest(START_INDEX);
		new TreeSetTest(START_INDEX);

	}

}
