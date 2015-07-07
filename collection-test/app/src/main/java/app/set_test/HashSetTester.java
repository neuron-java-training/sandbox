package app.set_test;

import java.util.HashSet;

import app.collection_element.CollectionElement;

public class HashSetTester extends SetTester{

	public HashSetTester(int initSize, int testSize) {
		super(new HashSet<CollectionElement>(), initSize, testSize);
	}
	
}
