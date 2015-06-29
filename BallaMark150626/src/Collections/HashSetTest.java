package Collections;

import hu.BallaMark.ComparableItem;
import hu.BallaMark.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetTest implements Test {
	private final String name = "HashSet test";
	private long begin = 0, end = 0;
	Set<ComparableItem> arraylist = new HashSet<>();

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
		TreeSet<ComparableItem> treeset = new TreeSet<>(this.arraylist);
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
