package hu.neuron.java.project.app;

import hu.neuron.java.project.core.TestArrayList;
import hu.neuron.java.project.core.TestLinkedList;
import hu.neuron.java.project.core.TestTreeSet;

import java.io.File;

public class TestRunnerWeb {
	public void runTest() {
		boolean fileCheck = true;
		int fileCounter = 0;

		if (!new File("result").exists()) {
			new File("result").mkdir();
		}
		while (fileCheck) {
			if (!new File("result//test" + fileCounter + "result.txt").isFile()) {
				fileCheck = false;
			} else {
				fileCounter++;
			}
		}

		TestLinkedList listTest = new TestLinkedList();
		TestThread<TestLinkedList> listTestRunnable = new TestThread<TestLinkedList>(listTest,
				"listTest", fileCounter);
		Thread listTestThread = new Thread(listTestRunnable);

		TestArrayList arrayTest = new TestArrayList();
		TestThread<TestArrayList> arrayTestRunnable = new TestThread<TestArrayList>(arrayTest,
				"arrayTest", fileCounter);
		Thread arrayTestThread = new Thread(arrayTestRunnable);

		TestTreeSet treeTest = new TestTreeSet();
		TestThread<TestTreeSet> treeTestRunnable = new TestThread<TestTreeSet>(treeTest,
				"treeTest", fileCounter);
		Thread treeTestThread = new Thread(treeTestRunnable);

		listTestThread.start();
		arrayTestThread.start();
		treeTestThread.start();

		while (listTestThread.isAlive() || arrayTestThread.isAlive() || treeTestThread.isAlive()) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
