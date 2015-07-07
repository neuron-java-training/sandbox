package app.list_test;

import java.util.ArrayList;

import app.collection_element.CollectionElement;

public class ArrayListTester extends ListTester{

	public ArrayListTester(int initSize, int testSize) {
		super(new ArrayList<CollectionElement>(), initSize, testSize);
	}

}
