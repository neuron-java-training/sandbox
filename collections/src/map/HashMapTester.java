package map;

import java.util.HashMap;

import tester.Test;

public class HashMapTester extends MapTester implements Test{

	@Override
	public long creationTest() {
		begin = System.nanoTime();
		map = new HashMap<>();
		end = System.nanoTime();
		return end - begin;
	}

	@Override
	public String getCollectionName() {
		return "HashMap";
	}

}
