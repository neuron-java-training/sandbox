package hu.neuron.test;

import hu.neuron.item.ComparableItem;
import hu.neuron.runner.ItemFactory;

import java.util.ArrayList;

public class ArrayListes extends Listes
{

	public ArrayListes(int start)
	{
		super(start);
	}

	@Override
	public void init()
	{
		long start = System.currentTimeMillis();
		lista = new ArrayList<ComparableItem>(ItemFactory.getItems());
		long end = System.currentTimeMillis();
		result.setInit(end - start);
	}

}
