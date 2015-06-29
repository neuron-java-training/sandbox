package hu.neuron.java.CollectionTest;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ListTester extends Tester {

	protected List<ListItem> list = null;
	private Random random = new Random();

	public ListTester(String testName, List<ListItem> list) {
		super(testName);
		this.list = list;
	}

	@Override
	public void init(int size) {
		ListItemFactory factory = new ListItemFactory();
		for (int i = 0; i < size; i++) {
			list.add(factory.getRandomListItem());
		}
	}

	@Override
	public void sort() {
		Collections.sort(list);
	}

	@Override
	public void get(int count) {
		for (int i = 0; i < count; i++) {
			list.get(random.nextInt(list.size()));
		}
	}

	@Override
	public void delete(int count) {
		for (int i = 0; i < count; i++) {
			list.remove(random.nextInt(list.size()));
		}
	}

}
