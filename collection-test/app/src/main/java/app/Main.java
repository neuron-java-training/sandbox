package app;

import core.test_result.TestResultIO;
import app.list_test.ArrayListTester;
import app.list_test.LinkedListTester;
import app.set_test.LinkedHashSetTester;
import app.set_test.TreeSetTester;
import app.test_runner.TestRunner;

public class Main {

	public Main() {
		TestRunner testRunner = new TestRunner();
		testRunner.addTest(new ArrayListTester());
		testRunner.addTest(new TreeSetTester());
		testRunner.addTest(new LinkedHashSetTester());
		testRunner.addTest(new LinkedListTester());
		testRunner.runAllTest();
		TestResultIO io = new TestResultIO();
		io.writeList(testRunner.getResultList());
		io.read();
	}
}
