package hu.neuron.test;

import hu.neuron.item.ComparableItem;
import hu.neuron.runner.Result;

import java.util.Collections;
import java.util.List;

public class Listes implements Teszt
{
	List<ComparableItem> lista;
	Result result = new Result();

	public Listes(int start)
	{
		this.init();
		this.rendez();
		this.listaz(start);
		this.delete(start);
		System.out.println(lista.getClass());
		System.out.println(result.toString());
	}

	@Override
	public void init()
	{
		long start = System.currentTimeMillis();
		// Cannot instantiate the type List, majd a leszármazottakat
		long end = System.currentTimeMillis();
		result.setInit(end - start);
	}

	@Override
	public void rendez()
	{
		long start = System.currentTimeMillis();
		Collections.sort(lista);
		long end = System.currentTimeMillis();
		result.setRendez(end - start);
	}

	@Override
	public void listaz(int db)
	{
		long start = System.currentTimeMillis();
		for (int i = 0; i < db; i++)
		{
			System.out.println(lista.get(i));
		}
		long end = System.currentTimeMillis();
		result.setListaz(end - start);
	}

	@Override
	public void delete(int from)
	{
		long start = System.currentTimeMillis();
		for (int i = from; i < lista.size(); i++)
		{
			lista.remove(i);
		}
		long end = System.currentTimeMillis();
		result.setDelete(end - start);
	}

	@Override
	public Result getResult()
	{
		return result;
	}

}
