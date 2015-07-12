package hu.neuron.java.myapp.app;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Tester {

	public static void doListTest() {
		TestResults adder;
		long a, b, diff = 0;
		TestRunner testrunner = new TestRunner();

		List<Items> t = new ArrayList<>();

		a = System.currentTimeMillis();
		testrunner.init(t);
		b = System.currentTimeMillis();
		diff = b - a;

		adder = new TestResults(Integer.valueOf(String.valueOf(diff)),
				new String("java.util.ArrayList"));

		TestRunner.getTestresults().add(adder);

		t = new LinkedList<>();

		a = System.currentTimeMillis();
		testrunner.init(t);
		b = System.currentTimeMillis();
		diff = b - a;

		adder = new TestResults(Integer.valueOf(String.valueOf(diff)),
				new String("java.util.LinkedList"));

		TestRunner.getTestresults().add(adder);
	}
	
	public static void doSetTest() {
		TestResults adder;
		long a, b, diff = 0;
		TestRunner testrunner = new TestRunner();
		
		Set<Items> sethelp = new HashSet<>();

		a = System.currentTimeMillis();
		testrunner.init(sethelp);
		b = System.currentTimeMillis();
		diff = b - a;

		adder = new TestResults(Integer.valueOf(String.valueOf(diff)),
				new String("java.util.HashSet"));

		TestRunner.getTestresults().add(adder);

		sethelp = new TreeSet<>();

		a = System.currentTimeMillis();
		testrunner.init(sethelp);
		b = System.currentTimeMillis();
		diff = b - a;

		adder = new TestResults(Integer.valueOf(String.valueOf(diff)),
				new String("java.util.TreeSet"));

		TestRunner.getTestresults().add(adder);
	}
	
	public static void doDequeTest(){
		TestResults adder;
		long a, b, diff = 0;
		TestRunner testrunner = new TestRunner();
		
		Deque<Items> d = new ArrayDeque<>();
		
		a = System.currentTimeMillis();
		testrunner.init(d);
		b = System.currentTimeMillis();
		diff = b - a;

		adder = new TestResults(Integer.valueOf(String.valueOf(diff)),
				new String("java.util.ArrayDeque"));

		TestRunner.getTestresults().add(adder);
		
	}
	
	public static void doQueueTest(){
		TestResults adder;
		long a, b, diff = 0;
		TestRunner testrunner = new TestRunner();
		
		Queue<Items> p = new PriorityQueue<>();
		
		a = System.currentTimeMillis();
		testrunner.init(p);
		b = System.currentTimeMillis();
		diff = b - a;

		adder = new TestResults(Integer.valueOf(String.valueOf(diff)),
				new String("java.util.PriorityQueue"));

		TestRunner.getTestresults().add(adder);
		
	}

}
