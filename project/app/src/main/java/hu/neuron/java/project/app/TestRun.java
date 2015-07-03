package hu.neuron.java.project.app;

import hu.neuron.java.project.app.Deque.GenericDequeTest;
import hu.neuron.java.project.app.List.GenericListTest;
import hu.neuron.java.project.app.Set.GenericSetTest;
import hu.neuron.java.project.core.IO;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class TestRun {
	ArrayList<Object> tests;
	ArrayList<Object> readData;
	String[] tmpData;
	String read;

	public TestRun() {
		this.tests = new ArrayList<>();
		this.readData = new ArrayList<>();
	}

	void test() {
		// this.tests.add(new ArrayListTest());
		// this.tests.add(new LinkedListTest());
		// this.tests.add(new HashSetTest());
		// this.tests.add(new TreeSetTest());
		// this.tests.add(new ArrayDequeTest());

		ArrayList<ComparableItem> arraylist = new ArrayList<>();
		GenericListTest<ArrayList<ComparableItem>> arraylistTest = new GenericListTest<>(arraylist);
		this.tests.add(arraylistTest);

		LinkedList<ComparableItem> linkedlist = new LinkedList<>();
		GenericListTest<LinkedList<ComparableItem>> linkedlistTest = new GenericListTest<>(
				linkedlist);
		this.tests.add(linkedlistTest);

		ArrayDeque<ComparableItem> arraydeque = new ArrayDeque<>();
		GenericDequeTest<ArrayDeque<ComparableItem>> arraydequeTest = new GenericDequeTest<>(
				arraydeque);
		this.tests.add(arraydequeTest);

		HashSet<ComparableItem> hashset = new HashSet<>();
		GenericSetTest<HashSet<ComparableItem>> hashsetTest = new GenericSetTest<>(hashset);
		this.tests.add(hashsetTest);

		TreeSet<ComparableItem> treeset = new TreeSet<>();
		GenericSetTest<TreeSet<ComparableItem>> treesetTest = new GenericSetTest<>(treeset);
		this.tests.add(treesetTest);

//		for (Test test : this.tests) {
//			System.out.println(test.toString());
//
//		}
		for (Object test : this.tests) {
			System.out.println(test.toString());

		}
		IO io = new IO();
		io.write(this.tests);

		this.read = io.read();

		this.tmpData = this.read.split(";");
		for (int i = 0; i < tmpData.length; i++) {
			this.readData.add(this.tmpData[i]);

		}

		System.out.println("\n\nk�sz");
	}

	public static void main(String[] args) {
		TestRun tr = new TestRun();
		tr.test();
	}

}
