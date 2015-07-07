package hu.neuron.java.myapp.app;

import hu.neuron.java.myapp.core.IO;

public class Main {

	public static void main(String[] args) {
		TestRunner testrunner = new TestRunner();
		IO io = new IO();

		Tester.doListTest();
		Tester.doSetTest();
		Tester.doQueueTest();
		Tester.doDequeTest();

		testrunner.order();

		io.write(TestRunner.testresults);

		System.out.println(TestRunner.INITNUMBER + " variable "
				+ "average init() time, with:\n");
		
		io.read();
	}
}