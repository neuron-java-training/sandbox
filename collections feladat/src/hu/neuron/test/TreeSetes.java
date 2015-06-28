package hu.neuron.test;

import hu.neuron.item.ComparableItem;
import hu.neuron.runner.ItemFactory;

import java.util.TreeSet;

public class TreeSetes extends Halmazos
{

	public TreeSetes(int db)
	{
		super(db);
	}
	
	@Override
	public void rendez()
	{
		long start = System.currentTimeMillis();
		halmaz = new TreeSet<ComparableItem>(ItemFactory.getItems());
		long end = System.currentTimeMillis();
		result2.setRendez(end - start);
	}

}
