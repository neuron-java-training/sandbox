package hu.neuron.java.project.app.List;

import hu.neuron.java.project.app.ComparableItem;
import hu.neuron.java.project.app.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericListTest<T extends List<ComparableItem>> implements Test {

	private String name;
	private long begin = 0, end = 0;
	T list;

	public GenericListTest(T t) {
		this.list=t;
		this.name=t.getClass().getName();
	}
	

	public long getTotalTime() {
		return this.end - this.begin;
	}

	@Override
	public void initBegin() {
		this.begin = System.currentTimeMillis();
	}

	@Override
	public void initEnd() {
		this.end = System.currentTimeMillis();
	}

	@Override
	public long order() {
		this.initBegin();
		List<ComparableItem> lista = new ArrayList<>();
		lista.addAll(list);
		Collections.sort(list);

		this.initEnd();

		return this.getTotalTime();
	}

	@Override
	public long delete(int s, int e) {
		this.initBegin();
		for (int i = s; i < e; i++) {
			list.remove(i);
		}
		this.initEnd();

		return this.getTotalTime();
	}

	@Override
	public long fill() {
		this.initBegin();
		for (int i = 0; i < 1_000_000; i++) {
			this.list.add(new ComparableItem((int) Math.random()));
		}
		this.initEnd();

		return this.getTotalTime();

	}

	@Override
	public String toString() {
		return this.name + " Fill: " + this.fill() + "\tOrder: " + this.order() + "\tDelete: "
				+ this.delete(1, 2);
	}
}
