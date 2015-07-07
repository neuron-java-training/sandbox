package app.list_test;


import java.util.Collections;
import java.util.List;
import java.util.Random;

import app.collection_element.CollectionElement;
import app.collection_element.CollectionElementFactory;

import common.collection_test.Tester;

public class ListTester extends Tester{

	private List<CollectionElement> list = null;
	private Random random = new Random();
	private CollectionElementFactory factory = null; 
	
	
	public ListTester(List<CollectionElement> list, int initSize, int testSize) {
		super(initSize, testSize);
		this.list = list;
		this.factory = new CollectionElementFactory();
	}

	@Override
	public long init() {
		long start = System.nanoTime();

		for (int i = 0; i < super.initSize; i++) {
			list.add(factory.getRandomCollectionElement());
		}

		long end = System.nanoTime();
		return end - start;
	}

	@Override
	public long sort() {
		long start = System.nanoTime();

		Collections.sort(list);

		long end = System.nanoTime();
		return end - start;
	}

	@Override
	public long get() {
		long start = System.nanoTime();
		
		for (int i = 0; i < super.testSize; i++) {
			list.get(random.nextInt(list.size()));
		}		
		
		long end = System.nanoTime();
		return end - start;
	}

	@Override
	public long delete() {
		long start = System.nanoTime();

		for (int i = 0; i < super.testSize; i++) {
			list.remove(random.nextInt(list.size()));
		}

		long end = System.nanoTime();
		return end - start;
	}

	@Override
	public String getTestName() {
		return list.getClass().getName();
	}
}
