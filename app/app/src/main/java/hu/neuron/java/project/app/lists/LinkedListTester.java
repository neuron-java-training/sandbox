package hu.neuron.java.project.app.lists;

import hu.neuron.java.project.app.tester.Test;

import java.util.LinkedList;

public class LinkedListTester extends ListTester implements Test {

	@Override
	public long creationTest() {
		begin = System.nanoTime();
		list = new LinkedList<>();
		end = System.nanoTime();
		return end - begin;
	}

	@Override
	public String getCollectionName() {
		
		return "LinkedList";
	}

}
