package hu.neuron.java.project.app.List;

import hu.neuron.java.project.app.ComparableItem;
import hu.neuron.java.project.app.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListTest implements Test {

	private final String name = "ArrayList test";
	private long begin = 0, end = 0;
	List<ComparableItem> arraylist = new ArrayList<>();

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
		Collections.sort(arraylist);
		this.initEnd();

		return this.getTotalTime();
	}

	@Override
	public long delete(int s, int e) {
		this.initBegin();
		for (int i = s; i < e; i++) {
			arraylist.remove(i);
		}
		this.initEnd();

		return this.getTotalTime();
	}

	@Override
	public long fill() {
		this.initBegin();
		for (int i = 0; i < 1_000_000; i++) {
			this.arraylist.add(new ComparableItem((int) Math.random()));
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
