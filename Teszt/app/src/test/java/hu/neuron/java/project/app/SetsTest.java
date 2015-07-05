package hu.neuron.java.project.app;

import static org.junit.Assert.*;
import hu.neuron.java.project.items.ComparableItem;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class SetsTest {


	@Test
	public void test1() {
		new Sets<HashSet<ComparableItem>>(
				new HashSet<ComparableItem>());;
	}
	
	@Test
	public void test2() {
		new Sets<TreeSet<ComparableItem>>(
				new TreeSet<ComparableItem>());

	}
	
	@Test
	public void test3() {
		new Sets<LinkedHashSet<ComparableItem>>(
				new LinkedHashSet<ComparableItem>());
	}

}
