package listtest;

import java.util.ArrayList;

import run.ItemFactory;

public class ArrayListTest extends Lists {

	public ArrayListTest(int startIndex) {
		super(startIndex);
	}

	@Override
	public void init() {
		long start = System.currentTimeMillis();
		super.items = new ArrayList<>(ItemFactory.getItems());
		long end = System.currentTimeMillis();
		res.setInit(end - start);

	}

}
