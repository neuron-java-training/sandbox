package hu.neuron.training.kollekciok.test;

import hu.neuron.training.kollekciok.test.impl.ArrayDequeTest;
import hu.neuron.training.kollekciok.test.impl.ArrayListTest;
import hu.neuron.training.kollekciok.test.impl.HashMapTest;
import hu.neuron.training.kollekciok.test.impl.HashSetTest;
import hu.neuron.training.kollekciok.test.impl.LinkedHashMapTest;
import hu.neuron.training.kollekciok.test.impl.LinkedHashSetTest;
import hu.neuron.training.kollekciok.test.impl.LinkedListDequeTest;
import hu.neuron.training.kollekciok.test.impl.LinkedListTest;
import hu.neuron.training.kollekciok.test.impl.TreeMapTest;
import hu.neuron.training.kollekciok.test.impl.TreeSetTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestRunner {
	private List<Test> tests;
	private static final int N = 5000;
	private static final int START_INDEX = 0;
	private int size;
	private int quantity;

	private void init() {
		tests.add(new ArrayListTest(size));
		tests.add(new LinkedListTest(size));
		tests.add(new HashMapTest(size));
		tests.add(new TreeMapTest(size));
		tests.add(new HashSetTest(size));
		tests.add(new TreeSetTest(size));
		tests.add(new LinkedHashSetTest(size));
		tests.add(new LinkedHashMapTest(size));
		tests.add(new ArrayDequeTest(size));
		tests.add(new LinkedListDequeTest(size));

	}

	public List<TestResult> test() {
		init();
		List<TestResult> eredmenyek = new ArrayList<TestResult>();
		Date kezdes;
		Date befejezes;
		long ido;
		for (Test test : tests) {
			System.out.println(test.getClass().getSimpleName());
			// init
			kezdes = new Date();
			test.init();
			befejezes = new Date();
			ido = befejezes.getTime() - kezdes.getTime();
			eredmenyek.add(new TestResult(test.getClass().getSimpleName() + "Init", ido));

			// sort
			kezdes = new Date();
			test.sort();
			befejezes = new Date();
			ido = befejezes.getTime() - kezdes.getTime();
			eredmenyek.add(new TestResult(test.getClass().getSimpleName() + "Sort", ido));

			// get
			kezdes = new Date();
			test.get(quantity);
			befejezes = new Date();
			ido = befejezes.getTime() - kezdes.getTime();
			eredmenyek.add(new TestResult(test.getClass().getSimpleName() + "Get", ido));

			// delete
			kezdes = new Date();
			test.delete(START_INDEX, quantity);
			befejezes = new Date();
			ido = befejezes.getTime() - kezdes.getTime();
			eredmenyek.add(new TestResult(test.getClass().getSimpleName() + "Delete", ido));

			test = null;
		}

		return eredmenyek;

	}

	public TestRunner(int size, int quantity) {
		super();
		this.tests = new ArrayList<Test>();
		this.size = size;
		this.quantity = quantity;
	}

	public TestRunner() {
		this.tests = new ArrayList<Test>();
		this.size = N;
		this.quantity = N-1;
	}

}
