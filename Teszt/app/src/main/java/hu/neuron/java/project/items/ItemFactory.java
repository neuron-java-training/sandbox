package hu.neuron.java.project.items;

import java.util.Collection;
import java.util.Random;

public class ItemFactory {

	private static final int MAX_ITEMS = 500_00;

	public static Collection<ComparableItem> getItems2(Class<?> t) {
		Collection<ComparableItem> comparableItem = null;

		try {
			comparableItem = (Collection<ComparableItem>) t.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < MAX_ITEMS; i++) {
			Random rand = new Random();
			String tmp = String.valueOf(rand.nextInt());
			comparableItem.add(new ComparableItem(tmp, tmp));
		}

		return comparableItem;
	}
}
