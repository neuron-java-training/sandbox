package tester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import dequeue.ArrayDequeTester;
import queue.PriorityQueueTester;
import sets.HashSetTester;
import sets.LinkedHashSetTester;
import sets.TreeSetTester;
import lists.ArrayListTester;
import lists.GenericListTester;
import lists.LinkedListTester;
import map.GenericMapTester;
import map.HashMapTester;
import map.LinkedHashMapTester;
import map.TreeMapTester;

public class GenericTestRunner {

	public ArrayList<Test> tests;
	public ArrayList<TestResult> results = new ArrayList<>();

	public GenericTestRunner() {
		tests = new ArrayList<>();
	}

	public void runTests() {

		long begin, end;
		begin = System.nanoTime();
		ArrayList<TestObject> al = new ArrayList<>();
		GenericListTester<ArrayList<TestObject>> alt = new GenericListTester<>(al);
		end = System.nanoTime();
		alt.setCreationTime(end-begin);
		
		begin = System.nanoTime();
		LinkedList<TestObject> ll = new LinkedList<>();
		GenericListTester<LinkedList<TestObject>> llt = new GenericListTester<>(ll);
		end = System.nanoTime();
		llt.setCreationTime(end-begin);
		
		begin = System.nanoTime();
		HashMap<TestObject,TestObject> hm = new HashMap<>();
		GenericMapTester<HashMap<TestObject,TestObject>> hmt = new GenericMapTester<>(hm);
		end = System.nanoTime();
		hmt.setCreationTime(end-begin);
		
		begin = System.nanoTime();
		LinkedHashMap<TestObject,TestObject> lhm = new LinkedHashMap<>();
		GenericMapTester<LinkedHashMap<TestObject,TestObject>> lhmt = new GenericMapTester<>(lhm);
		end = System.nanoTime();
		hmt.setCreationTime(end-begin);
		
		begin = System.nanoTime();
		TreeMap<TestObject,TestObject> tm = new TreeMap<>();
		GenericMapTester<TreeMap<TestObject,TestObject>> tmt = new GenericMapTester<>(tm);
		end = System.nanoTime();
		hmt.setCreationTime(end-begin);
		
		
		tests.add(alt);
		tests.add(llt);
		//tests.add(new ArrayListTester());
		//tests.add(new LinkedListTester());
		tests.add(new HashSetTester());
		tests.add(new TreeSetTester());
		tests.add(new LinkedHashSetTester());
		tests.add(new PriorityQueueTester());
		tests.add(new ArrayDequeTester());
		//tests.add(new HashMapTester());
		tests.add(new TreeMapTester());
		tests.add(new LinkedHashMapTester());
		tests.add(hmt);

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

		Collections.sort(results);
		for (TestResult tr : results) {
			tr.display();
		}
	}

	public static void main(String[] args) {
		GenericTestRunner runner = new GenericTestRunner();
		runner.runTests();
	}

}
