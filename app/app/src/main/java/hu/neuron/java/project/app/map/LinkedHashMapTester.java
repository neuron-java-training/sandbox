package hu.neuron.java.project.app.map;

import hu.neuron.java.project.app.tester.Test;

import java.util.LinkedHashMap;

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
