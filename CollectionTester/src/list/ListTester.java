package list;

import hu.neuron.java.CollectionTest.ListItem;
import hu.neuron.java.CollectionTest.ListItemFactory;
import hu.neuron.java.CollectionTest.Tester;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ListTester extends Tester {

	protected List<ListItem> list = null;
	private Random random = new Random();

	public ListTester(List<ListItem> list) {
		super();
		this.list = list;
	}

	@Override
	public long init(int size) {
		Date start = new Date();

		ListItemFactory factory = new ListItemFactory();
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
