package map;

import java.util.LinkedHashMap;

import tester.Test;

public class LinkedHashMapTester extends MapTester implements Test {

	@Override
	public long creationTest() {
		begin = System.nanoTime();
		map = new LinkedHashMap<>();
		end = System.nanoTime();
		return end - begin;
	}

	@Override
	public String getCollectionName() {
		return "LinkedHashMap";
	}

}
