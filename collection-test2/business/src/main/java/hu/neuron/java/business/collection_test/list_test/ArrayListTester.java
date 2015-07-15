package hu.neuron.java.business.collection_test.list_test;

import hu.neuron.java.business.collection_test.collection_element.CollectionElement;

import java.util.ArrayList;

public class ArrayListTester extends ListTester{

	public ArrayListTester(int initSize, int testSize) {
		super(new ArrayList<CollectionElement>(), initSize, testSize);
	}

}
