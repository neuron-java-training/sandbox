package hu.neuron.test;

import hu.neuron.item.ComparableItem;
import hu.neuron.runner.ItemFactory;
import hu.neuron.runner.Result;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Halmazos implements Teszt
{
	Set<ComparableItem> halmaz;
	Result result2 = new Result();

	public Halmazos(int db)
	{
		this.init();
		this.rendez();
		this.listaz(db);
		System.out.println(halmaz.getClass());
		System.out.println(result2.toString());
	}
	
	@Override
	public void init()
	{
		long start = System.currentTimeMillis();
		halmaz = new HashSet<ComparableItem>(ItemFactory.getItems());
		long end = System.currentTimeMillis();
		result2.setInit(end - start);
	}

	@Override
	public void rendez()
	{
		long start = System.currentTimeMillis();
		//can't
		long end = System.currentTimeMillis();
		result2.setRendez(end - start);
	}

	@Override
	public void listaz(int db)
	{
		long start = System.currentTimeMillis();
		Iterator<ComparableItem> iterator = halmaz.iterator();
		int i = 0;
		while (iterator.hasNext())
		{
			i++;
			if (i == db)
			{
				break;
			}
		}
		long end = System.currentTimeMillis();
		result2.setListaz(end - start);
	}

	@Override
	public void delete(int from)
	{
		// halmazban nem lehet intervallumot törölni
	}

	@Override
	public Result getResult()
	{
		return result2;
	}

}
