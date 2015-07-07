package app;

import java.util.List;

import core.test_result.TestResult;
import core.test_result.TestResultIO;
import app.list_test.ArrayListTester;
import app.list_test.LinkedListTester;
import app.set_test.HashSetTester;
import app.set_test.LinkedHashSetTester;
import app.set_test.TreeSetTester;
import app.test_runner.TestRunner;

public class Main {

	public Main() {
		
	}
	
	public List<TestResult> run(int initSize, int testSize){
		TestRunner testRunner = new TestRunner();
		testRunner.addTest(new ArrayListTester(initSize, testSize));
		testRunner.addTest(new LinkedListTester(initSize, testSize));
		testRunner.addTest(new TreeSetTester(initSize, testSize));
		testRunner.addTest(new LinkedHashSetTester(initSize, testSize));
		testRunner.addTest(new HashSetTester(initSize, testSize));
		testRunner.runAllTest();
		TestResultIO io = new TestResultIO();
		io.writeList(testRunner.getResultList());
		io.read();
		
		return testRunner.getResultList();
	}
}
