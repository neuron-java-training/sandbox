package hu.neuron.java.project.business.impl;


public class CollectionTestRunner {
	public boolean runTest() {

		CollectionTestImplLinkedList listTest = new CollectionTestImplLinkedList();
		CollectionTestThread<CollectionTestImplLinkedList> listTestRunnable = new CollectionTestThread<CollectionTestImplLinkedList>(
				listTest, "listTest");
		Thread listTestThread = new Thread(listTestRunnable);

		CollectionTestImplArrayList arrayTest = new CollectionTestImplArrayList();
		CollectionTestThread<CollectionTestImplArrayList> arrayTestRunnable = new CollectionTestThread<CollectionTestImplArrayList>(
				arrayTest, "arrayTest");
		Thread arrayTestThread = new Thread(arrayTestRunnable);

		CollectionTestImplTreeSet treeTest = new CollectionTestImplTreeSet();
		CollectionTestThread<CollectionTestImplTreeSet> treeTestRunnable = new CollectionTestThread<CollectionTestImplTreeSet>(
				treeTest, "treeTest");
		Thread treeTestThread = new Thread(treeTestRunnable);

		listTestThread.start();
		arrayTestThread.start();
		treeTestThread.start();

		while (listTestThread.isAlive() || arrayTestThread.isAlive() || treeTestThread.isAlive()) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
		return true;
	}
}
