package neuron4ora.feladatCollections2;

import java.io.File;

public class TestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean fileCheck = true;
		int fileCounter = 0;

		while (fileCheck) {
			if (!new File("test" + fileCounter + "result.txt").isFile()) {
				fileCheck = false;
			} else {
				fileCounter++;
			}
		}

		LinkedListTest listTest = new LinkedListTest();
		TestThread<LinkedListTest> listTestRunnable = new TestThread<LinkedListTest>(listTest,
				"listTest", fileCounter);
		Thread listTestThread = new Thread(listTestRunnable);

		ArrayListTest arrayTest = new ArrayListTest();
		TestThread<ArrayListTest> arrayTestRunnable = new TestThread<ArrayListTest>(arrayTest,
				"arrayTest", fileCounter);
		Thread arrayTestThread = new Thread(arrayTestRunnable);

		TreeSetTest treeTest = new TreeSetTest();
		TestThread<TreeSetTest> treeTestRunnable = new TestThread<TreeSetTest>(treeTest,
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
		System.out.println("All Finished");
	}

}
