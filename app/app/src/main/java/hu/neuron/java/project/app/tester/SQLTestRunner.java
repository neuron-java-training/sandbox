package hu.neuron.java.project.app.tester;

import hu.neuron.java.project.app.lists.GenericListTester;
import hu.neuron.java.project.app.map.GenericMapTester;
import hu.neuron.java.project.app.sets.GenericSetTester;
import hu.neuron.java.project.common.interfaces.Writer;
import hu.neuron.java.project.core.SQLWriter;
import hu.neuron.java.project.core.TestResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.stereotype.Component;

@Component
public class SQLTestRunner {

	public ArrayList<Test> tests;
	public ArrayList<TestResult> results;
	private Writer writer;
	
	public SQLTestRunner(){}

	public void runTests() {
		tests = new ArrayList<>();
		results = new ArrayList<>();

		long begin, end;
		begin = System.nanoTime();
		ArrayList<TestObject> al = new ArrayList<>();
		GenericListTester<ArrayList<TestObject>> alt = new GenericListTester<>(al);
		end = System.nanoTime();
		alt.setCreationTime(end-begin);
		tests.add(alt);
		
		begin = System.nanoTime();
		LinkedList<TestObject> ll = new LinkedList<>();
		GenericListTester<LinkedList<TestObject>> llt = new GenericListTester<>(ll);
		end = System.nanoTime();
		llt.setCreationTime(end-begin);
		tests.add(llt);
		
		begin = System.nanoTime();
		HashMap<TestObject,TestObject> hm = new HashMap<>();
		GenericMapTester<HashMap<TestObject,TestObject>> hmt = new GenericMapTester<>(hm);
		end = System.nanoTime();
		hmt.setCreationTime(end-begin);
		tests.add(hmt);
		
		begin = System.nanoTime();
		LinkedHashMap<TestObject,TestObject> lhm = new LinkedHashMap<>();
		GenericMapTester<LinkedHashMap<TestObject,TestObject>> lhmt = new GenericMapTester<>(lhm);
		end = System.nanoTime();
		lhmt.setCreationTime(end-begin);
		tests.add(lhmt);
		
		begin = System.nanoTime();
		TreeMap<TestObject,TestObject> tm = new TreeMap<>();
		GenericMapTester<TreeMap<TestObject,TestObject>> tmt = new GenericMapTester<>(tm);
		end = System.nanoTime();
		tmt.setCreationTime(end-begin);
		tests.add(tmt);
		
		begin = System.nanoTime();
		HashSet<TestObject> hs = new HashSet<>();
		GenericSetTester<HashSet<TestObject>> hst = new GenericSetTester<>(hs);
		end = System.nanoTime();
		hst.setCreationTime(end-begin);
		tests.add(hst);
		
		begin = System.nanoTime();
		LinkedHashSet<TestObject> lhs = new LinkedHashSet<>();
		GenericSetTester<LinkedHashSet<TestObject>> lhst = new GenericSetTester<>(lhs);
		end = System.nanoTime();
		lhst.setCreationTime(end-begin);
		tests.add(lhst);
		
		begin = System.nanoTime();
		TreeSet<TestObject> ts = new TreeSet<>();
		GenericSetTester<TreeSet<TestObject>> tst = new GenericSetTester<>(ts);
		end = System.nanoTime();
		tst.setCreationTime(end-begin);
		tests.add(tst);
			
		ExecutorService executor = Executors.newFixedThreadPool(8);
		ArrayList<Callable<TestResult>> threads = new ArrayList<>(8);
		ArrayList<Future<TestResult>> futures = new ArrayList<>(8);
		
		for (Test t : tests) {
			threads.add(new CallableResultGenerator(t));
		}
		for(Callable<TestResult> c : threads){
			futures.add(executor.submit(c));
		}
		
		executor.shutdown();

		ArrayList<TestResult> results = new ArrayList<>(8);
		for(Future<TestResult> f : futures){
			try {
				results.add(f.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		writer = new SQLWriter(results);
		writer.write();

	}

}
