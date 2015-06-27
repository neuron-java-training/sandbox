package kollekcioteszter;

import java.util.ArrayList;

import dequeue.ArrayDequeTester;
import queue.PriorityQueueTester;
import sets.HashSetTester;
import sets.LinkedHashSetTester;
import sets.TreeSetTester;
import lists.ArrayListTester;
import lists.LinkedListTester;

public class TestRunner {

	public ArrayList<Test> tests;
	public ArrayList<TestResult> results = new ArrayList<>();

	public TestRunner() {
		tests = new ArrayList<>();
	}

	public void runTests() {

		tests.add(new ArrayListTester());
		tests.add(new LinkedListTester());
		tests.add(new HashSetTester());
		tests.add(new TreeSetTester());
		tests.add(new LinkedHashSetTester());
		tests.add(new PriorityQueueTester());
		tests.add(new ArrayDequeTester());

		for (Test t : tests) {
			TestResult tr = new TestResult(t.getCollectionName());
			
			tr.setInitTime(t.creationTest());
			tr.setFillTime(t.fillTest());
			tr.setSortTime(t.sortTest());
			tr.setAccessTime(t.accessTest(3000));
			tr.setDeletionTime(t.deletionTest(2500, 3900));
			tr.setDuplicateEliminationTime(t.removeDuplicates());

			results.add(tr);
		}

		for (TestResult tr : results) {
			tr.display();
		}
	}

	public static void main(String[] args) {
		TestRunner runner = new TestRunner();
		runner.runTests();
	}

}
