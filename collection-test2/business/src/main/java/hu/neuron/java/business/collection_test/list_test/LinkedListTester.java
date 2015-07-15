package hu.neuron.java.business.collection_test.list_test;

import hu.neuron.java.business.collection_test.collection_element.CollectionElement;

import java.util.LinkedList;

public class LinkedListTester extends ListTester{

	public LinkedListTester(int initSize, int testSize) {
		super(new LinkedList<CollectionElement>(), initSize, testSize);
	}

	
	
}
