package hu.neuron.java.business.collection_test.set_test;

import hu.neuron.java.business.collection_test.collection_element.CollectionElement;

import java.util.LinkedHashSet;

public class LinkedHashSetTester extends SetTester{

	public LinkedHashSetTester(int initSize, int testSize) {
		super(new LinkedHashSet<CollectionElement>(), initSize, testSize);
	}

	
	
}
