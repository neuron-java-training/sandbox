package hu.neuron.java.project.app;

import hu.neuron.java.project.common.Result;
import hu.neuron.java.project.core.IO;
import hu.neuron.java.project.items.ComparableItem;
import hu.neuron.java.project.items.ItemFactory;

import java.util.Collections;
import java.util.List;

public class Lists<T extends List<ComparableItem>> implements Test, Runnable {

	protected List<ComparableItem> items;

	protected Result res = new Result();
	Class<?> t;

	public Lists(T t) {
		this.t = t.getClass();
	}

	@Override
	public void init(Class<?> t) {
		long start = System.currentTimeMillis();
		items = (List<ComparableItem>) ItemFactory.getItems2(t);
		long end = System.currentTimeMillis();
		res.setInit(end - start);

	}

	@Override
	public void sort() {
		long start = System.currentTimeMillis();
		Collections.sort(items);
		long end = System.currentTimeMillis();
		res.setSort(end - start);

	}

	@Override
	public void getElement() {
		long start = System.currentTimeMillis();
		for (int i = 0; i < items.size(); i++) {
			items.get(i);
		}
		long end = System.currentTimeMillis();
		res.setGetElement(end - start);

	}

	@Override
	public void delete() {
		long start = System.currentTimeMillis();
		for (int i = 0; i < items.size(); i++) {
			items.remove(i);
		}

		long end = System.currentTimeMillis();
		res.setDelete(end - start);

	}

	//@Override
	public Result getResult() {
		return res;
	}

	@Override
	public void run() {
		this.init(t);
		this.sort();
		this.getElement();
		this.delete();
		// System.out.println(items.getClass());
		res.setName(items.getClass().getName());

		// System.out.println(res.toString());
		IO io = new IO();	
		io.write(res);
		// System.out.println(IO.readRes().toString());

	}

}
