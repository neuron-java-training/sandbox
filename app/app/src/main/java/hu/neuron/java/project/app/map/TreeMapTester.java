package hu.neuron.java.project.app.map;

import hu.neuron.java.project.app.tester.Test;

import java.util.TreeMap;

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
