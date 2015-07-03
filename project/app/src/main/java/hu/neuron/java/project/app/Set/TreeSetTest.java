package hu.neuron.java.project.app.Set;

import hu.neuron.java.project.app.ComparableItem;
import hu.neuron.java.project.app.Test;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest implements Test {

	private final String name = "TreeSet test";
	private long begin = 0, end = 0;
	Set<ComparableItem> arraylist = new TreeSet<>();

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
		return 0;
	}

	@Override
	public long delete(int s, int e) {
		this.initBegin();
		ArrayList<ComparableItem> element = new ArrayList<>();
		ArrayList<ComparableItem> elementToRemove = new ArrayList<>();
		element.addAll(element);
		if (e < element.size()) {
			for (int i = s; i < e; i++) {
				elementToRemove.add(element.get(i));
			}
		}
		arraylist.removeAll(elementToRemove);
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
