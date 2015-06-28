package settest;

import java.util.HashSet;

import run.ItemFactory;

public class HashSetTest extends Sets {

	public HashSetTest(int startIndex) {
		super(startIndex);
	}

	@Override
	public void init() {
		long start = System.currentTimeMillis();
		super.items = new HashSet<>(ItemFactory.getItems());
		long end = System.currentTimeMillis();
		res.setInit(end - start);
	}

}
