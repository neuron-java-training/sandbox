package listtest;

import java.util.Collections;
import java.util.List;

import item.ComparableItem;
import run.Result;
import test.Test;

abstract public class Lists implements Test {

	protected List<ComparableItem> items;

	protected Result res = new Result();

	public Lists(int startIndex) {
		this.init();

		this.sort();
		this.getElement(startIndex);
		this.delete(startIndex);
		System.out.println(items.getClass());
		System.out.println(res.toString());
	}

	@Override
	public void init() {
	}

	@Override
	public void sort() {
		long start = System.currentTimeMillis();
		Collections.sort(items);
		long end = System.currentTimeMillis();
		res.setSort(end - start);

	}

	@Override
	public void getElement(int startIndex) {
		long start = System.currentTimeMillis();
		for (int i = startIndex; i < items.size(); i++) {
			items.get(i);
		}
		long end = System.currentTimeMillis();
		res.setGetElement(end - start);

	}

	@Override
	public void delete(int startIndex) {
		long start = System.currentTimeMillis();
		for (int i = startIndex; i < items.size(); i++) {
			items.remove(i);
		}

		long end = System.currentTimeMillis();
		res.setDelete(end - start);

	}

	@Override
	public Result getResult() {
		return res;
	}

}
