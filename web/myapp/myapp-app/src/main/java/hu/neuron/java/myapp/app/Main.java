package hu.neuron.java.myapp.app;

import java.util.List;


public class Main {
	
	public static List<TestResults> main(){
		
		TestRunner testrunner = new TestRunner();

		Tester.doListTest();
		Tester.doSetTest();
		Tester.doQueueTest();
		Tester.doDequeTest();

		testrunner.order();

		
		return TestRunner.getTestresults();
		
	}
}