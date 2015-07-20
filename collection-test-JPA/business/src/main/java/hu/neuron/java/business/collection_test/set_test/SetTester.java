package hu.neuron.java.business.collection_test.set_test;

import hu.neuron.java.business.collection_test.collection_element.CollectionElement;
import hu.neuron.java.business.collection_test.collection_element.CollectionElementFactory;
import hu.neuron.java.business_api.collection_test.Tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class SetTester extends Tester {

//	public static final int NON_RANDOM_INIT = 20;
	
	private int nonRandomInit;

	protected Set<CollectionElement> set = null;
	private List<CollectionElement> cElements = null;
	private CollectionElementFactory factory = null;

	public SetTester(Set<CollectionElement> set, int initSize, int testSize) {
		super(initSize, testSize);
		this.set = set;
		this.cElements = new ArrayList<>();
		this.factory = new CollectionElementFactory();
		this.nonRandomInit = testSize;
	}

	@Override
	public long init() {
		int realSize = super.initSize - nonRandomInit;

		for (int i = 0; i < nonRandomInit; i++) {
			cElements.add(factory.getRandomCollectionElement());
		}

		long start = System.nanoTime();

		for(int i = 0; i< nonRandomInit; i++){
			set.add(cElements.get(i));
		}
		
		for (int i = 0; i < realSize; i++) {
			set.add(factory.getRandomCollectionElement());
		}

		long end = System.nanoTime();
		return end - start;
	}

	@Override
	public long sort() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Sort");
	}

	@Override
	public long get() {
		int realSize = super.testSize - nonRandomInit;

		long start = System.nanoTime();	
		for (int i = 0; i < nonRandomInit; i++) {
			set.contains(cElements.get(i));
		}

		for (int i = 0; i < realSize; i++) {
			set.contains(factory.getRandomCollectionElement());
		}

		long end = System.nanoTime();
		return end - start;
	}

	@Override
	public long delete() {
		int realCount = super.testSize - nonRandomInit;

		long start = System.nanoTime();

		for (int i = 0; i < nonRandomInit; i++) {
			set.remove(cElements.get(i));
		}

		for (int i = 0; i < realCount; i++) {
			set.remove(factory.getRandomCollectionElement());
		}

		long end = System.nanoTime();
		return end - start;
	}

	@Override
	public String getTestName() {
		return set.getClass().getName();
	}

}
