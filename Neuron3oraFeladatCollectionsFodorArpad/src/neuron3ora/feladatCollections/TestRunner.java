package neuron3ora.feladatCollections;

public class TestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListTest listTest = new LinkedListTest();
		ArrayListTest arrayTest = new ArrayListTest();
		TreeSetTest treeTest = new TreeSetTest();
		TestResult listTestTimer = new TestResult("listTest");
		TestResult arrayTestTimer = new TestResult("arrayTest");
		TestResult treeTestTimer = new TestResult("treeTest");
		long timer = 0;

		// ListTest muveletek
		System.out.println("-------------------------------------------------");
		System.out.println("ListTest Muveletek: init->getItem(10)->"
				+ "sorting->deleteItemsByRange(10, 15)->duplicationClear");

		timer = System.nanoTime();
		listTest.init();
		listTestTimer.setInitTime(System.nanoTime() - timer);
		System.out.println(listTest.getDatas());

		timer = System.nanoTime();
		System.out.println(listTest.getItem(10));
		listTestTimer.setGetItemTime(System.nanoTime() - timer);

		timer = System.nanoTime();
		listTest.sorting();
		listTestTimer.setSortingTime(System.nanoTime() - timer);
		System.out.println(listTest.getDatas());

		timer = System.nanoTime();
		listTest.deleteItemsByRange(10, 15);
		listTestTimer.setDeleteItemsByRangeTime(System.nanoTime() - timer);
		System.out.println(listTest.getDatas());

		timer = System.nanoTime();
		listTest.duplicationClear();
		listTestTimer.setDuplicationClearTime(System.nanoTime() - timer);
		System.out.println(listTest.getDatas());

		// arrayTest muveletek
		System.out.println("-------------------------------------------------");
		System.out.println("ArrayTest Muveletek: init->getItem(10)->"
				+ "sorting->deleteItemsByRange(10, 15)->duplicationClear");

		timer = System.nanoTime();
		arrayTest.init();
		arrayTestTimer.setInitTime(System.nanoTime() - timer);
		System.out.println(arrayTest.getDatas());

		timer = System.nanoTime();
		System.out.println(arrayTest.getItem(10));
		arrayTestTimer.setGetItemTime(System.nanoTime() - timer);

		timer = System.nanoTime();
		arrayTest.sorting();
		arrayTestTimer.setSortingTime(System.nanoTime() - timer);
		System.out.println(arrayTest.getDatas());

		timer = System.nanoTime();
		arrayTest.deleteItemsByRange(10, 15);
		arrayTestTimer.setDeleteItemsByRangeTime(System.nanoTime() - timer);
		System.out.println(arrayTest.getDatas());

		timer = System.nanoTime();
		arrayTest.duplicationClear();
		arrayTestTimer.setDuplicationClearTime(System.nanoTime() - timer);
		System.out.println(arrayTest.getDatas());

		// treeTest muveletek
		System.out.println("-------------------------------------------------");
		System.out.println("TreeTest Muveletek: init->getItem(10)->"
				+ "sorting->deleteItemsByRange(10, 15)->duplicationClear");

		timer = System.nanoTime();
		treeTest.init();
		treeTestTimer.setInitTime(System.nanoTime() - timer);
		System.out.println(treeTest.getDatas());

		timer = System.nanoTime();
		System.out.println(treeTest.getItem(10));
		treeTestTimer.setGetItemTime(System.nanoTime() - timer);

		timer = System.nanoTime();
		treeTest.sorting();
		treeTestTimer.setSortingTime(System.nanoTime() - timer);

		timer = System.nanoTime();
		treeTest.deleteItemsByRange(10, 15);
		treeTestTimer.setDeleteItemsByRangeTime(System.nanoTime() - timer);
		System.out.println(treeTest.getDatas());

		timer = System.nanoTime();
		treeTest.duplicationClear();
		treeTestTimer.setDuplicationClearTime(System.nanoTime() - timer);

		// Adatok kiertekelese
		System.out.println("-------------------------------------------------");
		System.out.println("Ido adatok kiertekelese:");
		listTestTimer.getResult();
		arrayTestTimer.getResult();
		treeTestTimer.getResult();
	}

}
