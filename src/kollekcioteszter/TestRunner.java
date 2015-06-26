package kollekcioteszter;

import java.util.ArrayList;

public class TestRunner {
	
	public ArrayList<Test> tests;
	public ArrayList<TestResult> results = new ArrayList<>();
	
	public TestRunner(){
		tests = new ArrayList<>();
	}
	
	public void runTests(){
		
		tests.add(new ArrayListTester());
		tests.add(new LinkedListTester());
		
		for(Test t: tests){
			
			long begin = System.nanoTime();
			t.creationTest();
			long end = System.nanoTime();
			long difference = end - begin;
			
			TestResult tr = new TestResult();
			tr.setInitTime(difference);
			
			results.add(tr);
		}
		
		for (TestResult tr: results){
			System.out.println(tr.getInitTime());
		}
	}

	public static void main(String[] args){
		
		TestRunner runner = new TestRunner();
		runner.runTests();
	}
	
}
