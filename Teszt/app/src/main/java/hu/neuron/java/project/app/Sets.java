package hu.neuron.java.project.app;
import hu.neuron.java.project.common.IOInterface;
import hu.neuron.java.project.common.Result;
import hu.neuron.java.project.core.IO;
import hu.neuron.java.project.items.ComparableItem;
import hu.neuron.java.project.items.ItemFactory;

import java.util.Iterator;
import java.util.Set;

public class Sets<T extends Set<ComparableItem>> implements Test, Runnable {

	protected Set<ComparableItem> items;

	protected Result res = new Result();
	Class<?> t;

	public Sets(T t) {
		this.t = t.getClass();
	}

	@Override
	public void init(Class<?> t) {
		long start = System.currentTimeMillis();
		items = (Set<ComparableItem>) ItemFactory.getItems2(t);
		long end = System.currentTimeMillis();
		res.setInit(end - start);
	}

	@Override
	public void sort() {
	}

	@Override
	public void getElement() {
		long start = System.currentTimeMillis();
		for (Iterator<ComparableItem> it = items.iterator(); it.hasNext();) {
			it.next();
		}
		long end = System.currentTimeMillis();
		res.setGetElement(end - start);
	}

	@Override
	public void delete() {
		long start = System.currentTimeMillis();
		for (Iterator<ComparableItem> it = items.iterator(); it.hasNext();) {
			it.next();
			it.remove();
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
		IOInterface io = new IO();	
		io.write(res);
		// System.out.println(IO.readRes().toString());

	}

}
