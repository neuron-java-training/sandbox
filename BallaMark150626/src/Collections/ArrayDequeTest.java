package Collections;

import hu.BallaMark.ComparableItem;
import hu.BallaMark.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class ArrayDequeTest implements Test {

	private final String name = "ArrayList test";
	private long begin = 0, end = 0;
	ArrayDeque<ComparableItem> arraylist = new ArrayDeque<>();

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
		ArrayList<ComparableItem> element = new ArrayList<>();
		element.addAll(arraylist);
		Collections.sort(element);
		arraylist.clear();
		arraylist.addAll(element);

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
