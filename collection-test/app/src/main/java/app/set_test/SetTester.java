package app.set_test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import app.collection_element.CollectionElement;
import app.collection_element.CollectionElementFactory;
import common.collection_test.Tester;

public class SetTester extends Tester {

	public static final int NON_RANDOM_INIT = 20;

	protected Set<CollectionElement> set = null;
	private List<CollectionElement> cElements = null;
	private CollectionElementFactory factory = null;

	public SetTester(Set<CollectionElement> set) {
		super();
		this.set = set;
		this.cElements = new ArrayList<>();
		this.factory = new CollectionElementFactory();
	}

	@Override
	public long init(int size) {
		int realSize = size - NON_RANDOM_INIT;

		for (int i = 0; i < NON_RANDOM_INIT; i++) {
			cElements.add(factory.getRandomCollectionElement());
		}

		Date start = new Date();

		for (int i = 0; i < realSize; i++) {
			set.add(factory.getRandomCollectionElement());
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
		int realSize = count - NON_RANDOM_INIT;

		Date start = new Date();		
		for (int i = 0; i < NON_RANDOM_INIT; i++) {
			set.contains(cElements.get(i));
		}

		for (int i = 0; i < realSize; i++) {
			set.contains(factory.getRandomCollectionElement());
		}

		Date end = new Date();
		return end.getTime() - start.getTime();
	}

	@Override
	public long delete(int count) {
		int realCount = count - NON_RANDOM_INIT;

		Date start = new Date();

		for (int i = 0; i < NON_RANDOM_INIT; i++) {
			set.remove(cElements.get(i));
		}

		for (int i = 0; i < realCount; i++) {
			set.remove(factory.getRandomCollectionElement());
		}

		Date end = new Date();
		return end.getTime() - start.getTime();
	}

	@Override
	public String getTestName() {
		return set.getClass().getName();
	}

}
