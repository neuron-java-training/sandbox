package tester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

import sets.GenericSetTester;
import lists.GenericListTester;
import map.GenericMapTester;

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
		lhmt.setCreationTime(end-begin);
		
		begin = System.nanoTime();
		TreeMap<TestObject,TestObject> tm = new TreeMap<>();
		GenericMapTester<TreeMap<TestObject,TestObject>> tmt = new GenericMapTester<>(tm);
		end = System.nanoTime();
		tmt.setCreationTime(end-begin);
		
		begin = System.nanoTime();
		HashSet<TestObject> hs = new HashSet<>();
		GenericSetTester<HashSet<TestObject>> hst = new GenericSetTester<>(hs);
		end = System.nanoTime();
		hst.setCreationTime(end-begin);
		
		begin = System.nanoTime();
		LinkedHashSet<TestObject> lhs = new LinkedHashSet<>();
		GenericSetTester<LinkedHashSet<TestObject>> lhst = new GenericSetTester<>(lhs);
		end = System.nanoTime();
		lhst.setCreationTime(end-begin);
		
		begin = System.nanoTime();
		TreeSet<TestObject> ts = new TreeSet<>();
		GenericSetTester<TreeSet<TestObject>> tst = new GenericSetTester<>(ts);
		end = System.nanoTime();
		tst.setCreationTime(end-begin);	
		
		tests.add(alt);
		tests.add(llt);
		tests.add(hst);
		tests.add(lhst);
		tests.add(tst);
		tests.add(hmt);
		tests.add(lhmt);
		tests.add(tmt);

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
