package settest;

import item.ComparableItem;

import java.util.Iterator;
import java.util.Set;

import run.Result;
import test.Test;

abstract public class Sets implements Test {

	protected Set<ComparableItem> items;

	protected Result res = new Result();

	public Sets(int startIndex) {
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

	}

	@Override
	public void getElement(int startIndex) {
		long start = System.currentTimeMillis();
		for (Iterator<ComparableItem> it = items.iterator(); it.hasNext();) {
			it.next();
		}
		long end = System.currentTimeMillis();
		res.setGetElement(end - start);

	}

	@Override
	public void delete(int startIndex) {
		long start = System.currentTimeMillis();
		for (Iterator<ComparableItem> it = items.iterator(); it.hasNext();) {
			it.next();
			it.remove();
		}
		long end = System.currentTimeMillis();
		res.setDelete(end - start);

	}

	@Override
	public Result getResult() {
		return res;
	}

}
