package hu.neuron.java.project.app;

import hu.neuron.java.project.common.IOInterface;
import hu.neuron.java.project.core.IO;
import hu.neuron.java.project.items.ComparableItem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.Vector;

public class TestRunner {
	static final int START_INDEX = 0;

	static List<Test> test = new ArrayList<>();
	static ArrayList<Thread> tests = new ArrayList<Thread>();

	public static void add() {
		tests.add(new Thread(new Lists<ArrayList<ComparableItem>>(
				new ArrayList<ComparableItem>())));
		tests.add(new Thread(new Lists<LinkedList<ComparableItem>>(
				new LinkedList<ComparableItem>())));
		tests.add(new Thread(new Lists<Vector<ComparableItem>>(
				new Vector<ComparableItem>())));

		tests.add(new Thread(new Sets<HashSet<ComparableItem>>(
				new HashSet<ComparableItem>())));
		tests.add(new Thread(new Sets<TreeSet<ComparableItem>>(
				new TreeSet<ComparableItem>())));
		tests.add(new Thread(new Sets<LinkedHashSet<ComparableItem>>(
				new LinkedHashSet<ComparableItem>())));
	}

	public synchronized static void run() {
		for (int i = 0; i < tests.size(); i++) {
			tests.get(i).start();
		}
	}

	public static boolean isAlive() {
		for (int i = 0; i < tests.size(); i++) {
			if (tests.get(i).isAlive())
				return true;
		}
		return false;
	}

	public static void IO() {
		while (true) {
			if (!TestRunner.isAlive()) {
				IOInterface io = new IO();
				io.read();
				break;
			} else {
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
