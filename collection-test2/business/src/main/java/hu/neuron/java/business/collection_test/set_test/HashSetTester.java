package hu.neuron.java.business.collection_test.set_test;

import hu.neuron.java.business.collection_test.collection_element.CollectionElement;

import java.util.HashSet;

public class HashSetTester extends SetTester{

	public HashSetTester(int initSize, int testSize) {
		super(new HashSet<CollectionElement>(), initSize, testSize);
	}
	
}
