package sets;

import java.util.HashSet;
import java.util.TreeSet;

import tester.Test;
import tester.TestObject;

public class HashSetTester extends SetTester implements Test {

	@Override
	public long creationTest() {
		begin = System.nanoTime();
		set = new HashSet<>();
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
		return "HashSet";
	}

}
