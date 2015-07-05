package hu.neuron.java.project.app;

import hu.neuron.java.project.items.ComparableItem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

import org.junit.Test;

public class ListTest {

	@Test
	public void test1() {
		new Lists<ArrayList<ComparableItem>>(
				new ArrayList<ComparableItem>());
	}
	
	@Test
	public void test2() {
		new Lists<LinkedList<ComparableItem>>(
				new LinkedList<ComparableItem>());
	}
	
	@Test
	public void test3() {
		new Lists<Vector<ComparableItem>>(
				new Vector<ComparableItem>());
	}

}
