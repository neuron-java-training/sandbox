package hu.neuron.java.CollectionTest;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import list.GenericListTester;
import set.GenericSetTester;

public class GenericTestRunner {

	private List<TestResult> resultList = null;
	
	public GenericTestRunner() {
		super();
		this.resultList = new ArrayList<>();
	}

	public TestResult runTest(Tester tester){
		System.out.println("Run test: " + tester.getTestName());
		
		TestResult result = new TestResult(tester.getTestName());
		
		result.setInitTime(tester.init(Tester.LIST_SIZE));
		result.setAccessTime(tester.get(Tester.TEST_SIZE));
		result.setDeleteTime(tester.delete(Tester.TEST_SIZE));
		try{
			result.setSortTime(tester.sort());
		}catch(UnsupportedOperationException ex){
			result.setSortTime(-1);
		}
		
		return result;
	}
	
	public void addResult(TestResult result){
		this.resultList.add(result);
	}
	
	@Override
	public String toString() {
		String result = "";
		for (TestResult r : resultList) {
			result+= r + "\n";
		}
		return result;
	}

	public static void main(String[] args) {
		
		GenericTestRunner testRunner = new GenericTestRunner();
		
		ArrayList<ListItem> al = new ArrayList<>();
		GenericListTester<ArrayList<ListItem>> alt = new GenericListTester<>(al);
		testRunner.resultList.add(testRunner.runTest(alt));
		
		LinkedList<ListItem> ll = new LinkedList<>();
		GenericListTester<LinkedList<ListItem>> llt = new GenericListTester<>(ll);
		testRunner.resultList.add(testRunner.runTest(llt));
		
		TreeSet<ListItem> ts = new TreeSet<>();
		GenericSetTester<TreeSet<ListItem>> tst = new GenericSetTester<>(ts);
		testRunner.resultList.add(testRunner.runTest(tst));
		
		LinkedHashSet<ListItem> lhs = new LinkedHashSet<>();
		GenericSetTester<LinkedHashSet<ListItem>> lhst = new GenericSetTester<>(lhs);
		testRunner.resultList.add(testRunner.runTest(lhst));
		
		System.out.println(testRunner);
		
	}
}
