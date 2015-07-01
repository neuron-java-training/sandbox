package run;

import item.ComparableItem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.Vector;

import test.Lists;
import test.Sets;
import test.Test;

public class TestRunner {
	static final int START_INDEX = 0;
	
	static List<Test>  test = new ArrayList<>();

	public static void run() {
		test.add(new Lists<ArrayList<ComparableItem>>(new ArrayList<ComparableItem>()));
		test.add(new Lists<LinkedList<ComparableItem>>(new LinkedList<ComparableItem>()));
		test.add(new Lists<Vector<ComparableItem>>(new Vector<ComparableItem>()));
		
		test.add(new Sets<HashSet<ComparableItem>>(new HashSet<ComparableItem>()));
		test.add(new Sets<TreeSet<ComparableItem>>(new TreeSet<ComparableItem>()));
		test.add(new Sets<LinkedHashSet<ComparableItem>>(new LinkedHashSet<ComparableItem>()));
		
	}
	
	public static int getTestNumber() {
		return test.size();
	}

}
