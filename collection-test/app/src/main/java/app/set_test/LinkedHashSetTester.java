package app.set_test;

import java.util.LinkedHashSet;

import app.collection_element.CollectionElement;

public class LinkedHashSetTester extends SetTester{

	public LinkedHashSetTester(int initSize, int testSize) {
		super(new LinkedHashSet<CollectionElement>(), initSize, testSize);
	}

	
	
}
