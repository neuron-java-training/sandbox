package hu.neuron.java.project.app.sets;

import hu.neuron.java.project.app.tester.Test;
import hu.neuron.java.project.app.tester.TestObject;

import java.util.LinkedHashSet;
import java.util.TreeSet;

public class LinkedHashSetTester extends SetTester implements Test {

	@Override
	public long creationTest() {
		begin = System.nanoTime();
		set = new LinkedHashSet<>();
		end = System.nanoTime();
		return end - begin;
	}

	@Override
	public long sortTest() {
		begin = System.nanoTime();
		@SuppressWarnings("unused")
		TreeSet<TestObject> ts = new TreeSet<>(set);
		end = System.nanoTime();
		return end - begin;
	}

	@Override
	public String getCollectionName() {
		return "LinkedHashSet";
	}

}
