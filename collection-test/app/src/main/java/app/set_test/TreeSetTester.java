package app.set_test;

import java.util.TreeSet;

import app.collection_element.CollectionElement;

public class TreeSetTester extends SetTester{

	public TreeSetTester(int initSize, int testSize) {
		super(new TreeSet<CollectionElement>(), initSize, testSize);
	}	
}
