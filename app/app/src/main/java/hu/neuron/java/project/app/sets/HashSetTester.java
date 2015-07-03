package hu.neuron.java.project.app.sets;

import hu.neuron.java.project.app.tester.Test;
import hu.neuron.java.project.app.tester.TestObject;

import java.util.HashSet;
import java.util.TreeSet;

public class HashSetTester extends SetTester implements Test {

	@Override
	public long creationTest() {
		begin = System.nanoTime();
		set = new HashSet<>();
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
		return "HashSet";
	}

}
