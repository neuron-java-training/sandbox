package hu.neuron.java.business.collection_test.set_test;

import hu.neuron.java.business.collection_test.collection_element.CollectionElement;

import java.util.TreeSet;

public class TreeSetTester extends SetTester{

	public TreeSetTester(int initSize, int testSize) {
		super(new TreeSet<CollectionElement>(), initSize, testSize);
	}	
}
