package app.list_test;


import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import app.collection_element.CollectionElement;
import app.collection_element.CollectionElementFactory;
import common.collection_test.Tester;

public class ListTester extends Tester{

	protected List<CollectionElement> list = null;
	private Random random = new Random();

	public ListTester(List<CollectionElement> list) {
		super();
		this.list = list;
	}

	@Override
	public long init(int size) {
		Date start = new Date();

		CollectionElementFactory factory = new CollectionElementFactory();
		for (int i = 0; i < size; i++) {
			list.add(factory.getRandomListItem());
		}

		Date end = new Date();
		return end.getTime() - start.getTime();
	}

	@Override
	public long sort() {
		Date start = new Date();
		
		Collections.sort(list);
		
		Date end = new Date();
		return end.getTime() - start.getTime();
	}

	@Override
	public long get(int count) {
		Date start = new Date();
		
		for (int i = 0; i < count; i++) {
			list.get(random.nextInt(list.size()));
		}
		
		Date end = new Date();
		return end.getTime() - start.getTime();
	}

	@Override
	public long delete(int count) {
		Date start = new Date();
		
		for (int i = 0; i < count; i++) {
			list.remove(random.nextInt(list.size()));
		}
		
		Date end = new Date();
		return end.getTime() - start.getTime();
	}

	@Override
	public String getTestName() {
		return list.getClass().getName();
	}

}
