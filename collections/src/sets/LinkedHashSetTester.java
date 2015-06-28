package sets;

import java.util.LinkedHashSet;
import java.util.TreeSet;

import tester.Test;
import tester.TestObject;

public class LinkedHashSetTester extends SetTester implements Test {

	@Override
	public long creationTest() {
		begin = System.nanoTime();
		set = new LinkedHashSet<>();
		end = System.nanoTime();
		return end - begin;
	}

	@Override
	public long sortTest() {
		begin = System.nanoTime();
		@SuppressWarnings("unused")
		TreeSet<TestObject> ts = new TreeSet<>(set);
		end = System.nanoTime();
		return end - begin;
	}

	@Override
	public String getCollectionName() {
		return "LinkedHashSet";
	}

}
