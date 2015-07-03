package hu.neuron.java.project.app;

import hu.neruon.java.project.common.Test;

import hu.neuron.java.project.core.IO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class TestRunner implements Test {
	static final long db = 5000000;
	static final List<TestResults> testresults = new ArrayList<>();
	
	public static void main(String[] args) {
		TestRunner testrunner = new TestRunner();
		testrunner.TimeCounter();
		testrunner.order();
		
		//testrunner.getElement("java.util.LinkedList");
		IO io = new IO();
		io.write(testresults);
		
		io.read();
	}

	@Override
	public void order() {
		Collections.sort(testresults, new Comparator<TestResults>() {

			@Override
			public int compare(TestResults o1, TestResults o2) {
				
			int cmp = o1.getInitTime() - o2.getInitTime();
			return cmp;
			}
		});

	}

	@Override
	public void getElement(String index) {
		for (int i = 0; i < testresults.size(); i++) {
			if (testresults.get(i).getClazzName().equals(index)) {
				System.out.println(testresults.get(i));
			}
		}
	}

	@Override
	public void delete(int a, int b) {
		for (int i = a; i <= b; i++) {
			testresults.remove(i);
		}

	}

	@Override
	public void TimeCounter() {
		List<Items> t = new ArrayList<>();

		long a, b, diff = 0;
		a = System.currentTimeMillis();
		init(t);
		b = System.currentTimeMillis();
		diff = b - a;

		TestResults adder = new TestResults(Integer.valueOf(String
				.valueOf(diff)), new String("java.util.ArrayList"));

		testresults.add(adder);

		t = new LinkedList<>();

		a = System.currentTimeMillis();
		init(t);
		b = System.currentTimeMillis();
		diff = b - a;

		adder = new TestResults(Integer.valueOf(String.valueOf(diff)),
				new String("java.util.LinkedList"));

		testresults.add(adder);

		Set<Items> sethelp = new HashSet<>();
		
		a = System.currentTimeMillis();
		init(sethelp);
		b = System.currentTimeMillis();
		diff = b - a;

		adder = new TestResults(Integer.valueOf(String.valueOf(diff)),
				new String("java.util.HashSet"));
		
		testresults.add(adder);
		
		sethelp = new TreeSet<>();
		
		a = System.currentTimeMillis();
		init(sethelp);
		b = System.currentTimeMillis();
		diff = b - a;

		adder = new TestResults(Integer.valueOf(String.valueOf(diff)),
				new String("java.util.TreeSet"));
		
		testresults.add(adder);

		

	}

	@Override
	public void init(Set t) {
		Random rand = new Random();
		for (int i = 0; i < db; i++) {
			int values = rand.nextInt();
			t.add(values);
		}

	}

	public void init(List t) {
		Random rand = new Random();
		for (int i = 0; i < db; i++) {
			int values = rand.nextInt();
			t.add(values);
		}
	}
}
