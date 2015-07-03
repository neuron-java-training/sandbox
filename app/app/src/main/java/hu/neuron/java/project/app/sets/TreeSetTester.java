package hu.neuron.java.project.app.sets;

import hu.neuron.java.project.app.tester.Test;

import java.util.TreeSet;

public class TreeSetTester extends SetTester implements Test {

	@Override
	public long creationTest() {
		begin = System.nanoTime();
		set = new TreeSet<>();
		end = System.nanoTime();
		return end - begin;
	}

	@Override
	public long sortTest() {
		return 0;
	}

	@Override
	public String getCollectionName() {
		return "TreeSet";
	}

}
