package hu.neuron.java.project.app.lists;

import hu.neuron.java.project.app.tester.Test;

import java.util.ArrayList;

public class ArrayListTester extends ListTester implements Test {
	
	@Override
	public long creationTest() {
		begin = System.nanoTime();
		list = new ArrayList<>();
		end = System.nanoTime();
		return end - begin;
	}

	@Override
	public String getCollectionName() {
		return "ArrayList";
	}

}
