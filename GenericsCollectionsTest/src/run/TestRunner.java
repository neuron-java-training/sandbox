package run;

import item.ComparableItem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.Vector;

import javax.swing.plaf.SliderUI;

import test.Lists;
import test.Sets;
import test.Test;

public class TestRunner  {
	static final int START_INDEX = 0;
	
	static List<Test>  test = new ArrayList<>();
	static ArrayList<Thread> tests = new ArrayList<Thread>();

	public static void add() {
		//Thread t1 = new Thread(new Lists<ArrayList<ComparableItem>>(new ArrayList<ComparableItem>()));
		tests.add(new Thread(new Lists<ArrayList<ComparableItem>>(new ArrayList<ComparableItem>())));
		tests.add(new Thread(new Lists<LinkedList<ComparableItem>>(new LinkedList<ComparableItem>())));
		tests.add(new Thread(new Lists<Vector<ComparableItem>>(new Vector<ComparableItem>())));
		
		tests.add(new Thread(new Sets<HashSet<ComparableItem>>(new HashSet<ComparableItem>())) );
		tests.add(new Thread(new Sets<TreeSet<ComparableItem>>(new TreeSet<ComparableItem>())) );
		tests.add(new Thread(new Sets<LinkedHashSet<ComparableItem>>(new LinkedHashSet<ComparableItem>())) );
		
//		test.add(new Lists<ArrayList<ComparableItem>>(new ArrayList<ComparableItem>()));
//		test.add(new Lists<LinkedList<ComparableItem>>(new LinkedList<ComparableItem>()));
//		test.add(new Lists<Vector<ComparableItem>>(new Vector<ComparableItem>()));
//		
//		test.add(new Sets<HashSet<ComparableItem>>(new HashSet<ComparableItem>()));
//		test.add(new Sets<TreeSet<ComparableItem>>(new TreeSet<ComparableItem>()));
//		test.add(new Sets<LinkedHashSet<ComparableItem>>(new LinkedHashSet<ComparableItem>()));
		
	}
	
	public static void run() {
	
		for (int i = 0; i < tests.size(); i++) {
			tests.get(i).start();
		}
	}
	
	public static boolean isAlive() {
		for (int i = 0; i < tests.size(); i++) {
			if ( tests.get(i).isAlive() )
				return true;
		}
		return false;
	}
	
	public static void IO() {
		while (true ) {
			if (!TestRunner.isAlive()) {
				IO.read();
				break;
			}
			else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
			
	}
	
	public static int getTestNumber() {
		return tests.size();
	}

}
