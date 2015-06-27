package sets;

import java.util.TreeSet;

import kollekcioteszter.Test;

public class TreeSetTester extends SetTester implements Test {

	@Override
	public long creationTest() {
		begin = System.nanoTime();
		set = new TreeSet<>();
		end = System.nanoTime();
		return end - begin;
	}

	@Override
	public long sortTest() {
		return 0;
	}

	@Override
	public String getCollectionName() {
		return "TreeSet";
	}

}
