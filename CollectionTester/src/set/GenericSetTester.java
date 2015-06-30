package set;

import hu.neuron.java.CollectionTest.ListItem;
import hu.neuron.java.CollectionTest.ListItemFactory;
import hu.neuron.java.CollectionTest.Tester;

import java.util.Date;
import java.util.Set;

public class GenericSetTester<T extends Set<ListItem>> extends Tester {

	protected Set<ListItem> set = null;

	public GenericSetTester(T t) {
		super();
		this.set = t;
	}

	@Override
	public String getTestName(){
		return set.getClass().getName();
	}
	
	@Override
	public long init(int size) {
		Date start = new Date();

		ListItemFactory factory = new ListItemFactory();
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

		ListItemFactory factory = new ListItemFactory();
		for (int i = 0; i < count; i++) {
			set.contains(factory.getRandomListItem());
		}

		Date end = new Date();
		return end.getTime() - start.getTime();
	}

	@Override
	public long delete(int count) {
		Date start = new Date();

		ListItemFactory factory = new ListItemFactory();
		for (int i = 0; i < count; i++) {
			set.remove(factory.getRandomListItem());
		}

		Date end = new Date();
		return end.getTime() - start.getTime();
	}
}
