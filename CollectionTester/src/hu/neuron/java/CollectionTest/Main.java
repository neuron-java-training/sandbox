package hu.neuron.java.CollectionTest;

import list.ArrayListTester;
import list.LinkedListTester;
import set.LinkedHashSetTester;
import set.TreeSetTester;

public class Main {

	public static void main(String[] args) {
		TestRunner testRunner = new TestRunner();

		testRunner.addTest(new ArrayListTester());
		testRunner.addTest(new TreeSetTester());
		testRunner.addTest(new LinkedHashSetTester());
		testRunner.addTest(new LinkedListTester());
		
		testRunner.runAllTest();

		System.out.println(testRunner);
		testRunner.writeResultsToFile("result.txt");
	}
}
