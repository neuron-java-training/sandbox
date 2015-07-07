package app.list_test;

import java.util.LinkedList;

import app.collection_element.CollectionElement;

public class LinkedListTester extends ListTester{

	public LinkedListTester(int initSize, int testSize) {
		super(new LinkedList<CollectionElement>(), initSize, testSize);
	}

	
	
}
