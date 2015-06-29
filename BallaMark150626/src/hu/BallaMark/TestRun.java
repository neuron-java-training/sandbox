package hu.BallaMark;

import java.util.ArrayList;
import java.util.List;

import Collections.ArrayDequeTest;
import Collections.ArrayListTest;
import Collections.HashSetTest;
import Collections.LinkedListTest;
import Collections.TreeSetTest;

public class TestRun {
	List<Test> tests;

	public TestRun() {
		this.tests = new ArrayList<>();
	}

	void test() {
		this.tests.add(new ArrayListTest());
		this.tests.add(new LinkedListTest());
		this.tests.add(new HashSetTest());
		this.tests.add(new TreeSetTest());
		this.tests.add(new ArrayDequeTest());

		for (Test test : this.tests) {
			System.out.println(test.toString());
		}

	}

	public static void main(String[] args) {
		TestRun tr = new TestRun();
		tr.test();
	}

}
