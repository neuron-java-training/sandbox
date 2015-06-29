package hu.neuron.java.CollectionTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestRunner {

	private static final int LIST_SIZE = 1_000_000;
	private static final int TEST_SIZE = 1_000;
	private List<TestResult> resultList = null;
	
	public TestRunner() {
		super();
		this.resultList = new ArrayList<>();
	}

	public TestResult runTest(Tester tester){
		System.out.println("Run test: " + tester.getTestName());
		
		TestResult result = new TestResult(tester.getTestName());
		Date start, end;
		
		start = new Date();
		tester.init(LIST_SIZE);
		end = new Date();
		result.setInitTime(end.getTime() - start.getTime());
		
		try{
			start = new Date();
			tester.sort();
			end = new Date();
			result.setSortTime(end.getTime() - start.getTime());
		}catch(UnsupportedOperationException ex){
			result.setSortTime(-1);
		}
		
		start = new Date();
		tester.get(TEST_SIZE);
		end = new Date();
		result.setAccessTime(end.getTime() - start.getTime());
		
		start = new Date();
		tester.delete(TEST_SIZE);
		end = new Date();
		result.setDeleteTime(end.getTime() - start.getTime());
		
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
		
		TestRunner testRunner = new TestRunner();
		
		testRunner.resultList.add(testRunner.runTest(new ArrayListTester()));
		testRunner.resultList.add(testRunner.runTest(new LinkedListTester()));
		testRunner.resultList.add(testRunner.runTest(new TreeSetTester()));
		testRunner.resultList.add(testRunner.runTest(new LinkedHashSetTester()));
		
		System.out.println(testRunner);
		
	}
}
