package map;

import java.util.TreeMap;

import tester.Test;

public class TreeMapTester extends MapTester implements Test {

	@Override
	public long creationTest() {
		begin = System.nanoTime();
		map = new TreeMap<>();
		end = System.nanoTime();
		return end - begin;
	}
	
	@Override
	public long sortTest() {
		return 0;
	}

	@Override
	public String getCollectionName() {
		return "TreeMap";
	}

}
