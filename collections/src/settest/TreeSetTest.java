package settest;

import java.util.TreeSet;

import run.ItemFactory;

public class TreeSetTest extends Sets {
	
	public TreeSetTest(int startIndex) {
		super(startIndex);
	}

	@Override
	public void init() {
		long start = System.currentTimeMillis();
		super.items = new TreeSet<>(ItemFactory.getItems());
		long end = System.currentTimeMillis();
		res.setInit(end - start);
	}

}
