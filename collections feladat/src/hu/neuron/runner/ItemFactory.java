package hu.neuron.runner;

import hu.neuron.item.ComparableItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class ItemFactory
{
	public static Collection<ComparableItem> getItems()
	{
		List<ComparableItem> comparableItem = new ArrayList<>();
		for (int i = 0; i < 2_800; i++)
		{
			Random rand = new Random();
			String tmp = String.valueOf(rand.nextInt());
			comparableItem.add(new ComparableItem(tmp, tmp));
		}
		return comparableItem;

	}
}
