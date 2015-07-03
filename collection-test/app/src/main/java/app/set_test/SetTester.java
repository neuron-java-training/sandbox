package app.set_test;

import java.util.Date;
import java.util.Set;

import app.collection_element.CollectionElement;
import app.collection_element.CollectionElementFactory;
import common.collection_test.Tester;

public class SetTester extends Tester{

protected Set<CollectionElement> set = null;
	
	
	public SetTester(Set<CollectionElement> set) {
		super();
		this.set = set;
	}

	@Override
	public long init(int size) {
		Date start = new Date();
		
		CollectionElementFactory factory = new CollectionElementFactory();
		for (int i = 0; i < size; i++) {
			set.add(factory.getRandomListItem());
		}
		
		Date end = new Date();
		return end.getTime() - start.getTime();
	}

	@Override
	public long sort() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Sort");
	}

	@Override
	public long get(int count) {
		Date start = new Date();
		
		CollectionElementFactory factory = new CollectionElementFactory();
		for (int i = 0; i < count; i++) {
			set.contains(factory.getRandomListItem());
		}
		
		Date end = new Date();
		return end.getTime() - start.getTime();
	}

	@Override
	public long delete(int count) {
		Date start = new Date();
		
		CollectionElementFactory factory = new CollectionElementFactory();
		for (int i = 0; i < count; i++) {
			set.remove(factory.getRandomListItem());
		}		
		
		Date end = new Date();
		return end.getTime() - start.getTime();
	}

	@Override
	public String getTestName() {
		return set.getClass().getName();
	}
	
}
