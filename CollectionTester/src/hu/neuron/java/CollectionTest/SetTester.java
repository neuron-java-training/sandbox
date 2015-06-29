package hu.neuron.java.CollectionTest;

import java.util.Set;

public class SetTester extends Tester{

	protected Set<ListItem> set = null;
	
	
	public SetTester(String testName, Set<ListItem> set) {
		super(testName);
		this.set = set;
	}

	@Override
	public void init(int size) {
		ListItemFactory factory = new ListItemFactory();
		for (int i = 0; i < size; i++) {
			set.add(factory.getRandomListItem());
		}
	}

	@Override
	public void sort() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Sort");
	}

	@Override
	public void get(int count) {
		ListItemFactory factory = new ListItemFactory();
		for (int i = 0; i < count; i++) {
			set.contains(factory.getRandomListItem());
		}
	}

	@Override
	public void delete(int count) {
		ListItemFactory factory = new ListItemFactory();
		for (int i = 0; i < count; i++) {
			set.remove(factory.getRandomListItem());
		}		
	}
}
