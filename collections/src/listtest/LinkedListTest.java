package listtest;

import java.util.LinkedList;

import run.ItemFactory;

public class LinkedListTest extends Lists {

	public LinkedListTest(int startIndex) {
		super(startIndex);
	}

	@Override
	public void init() {
		long start = System.currentTimeMillis();
		super.items = new LinkedList<>(ItemFactory.getItems());
		long end = System.currentTimeMillis();
		res.setInit(end - start);
	}

}
