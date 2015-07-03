package hu.neuron.java.project.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ArrayListTest implements Test {
	
	ArrayList<Item> myArrayList = new ArrayList<Item>();
	private long time1, time2;

	public ArrayListTest() {
		super();
	}

	
	public long init() {
		// TODO Auto-generated method stub
		time1 = System.currentTimeMillis();
		for (int i = 0; i < 500000 ; i++) {
			myArrayList.add(new Item((int)Math.random()));
		}
		time2 = System.currentTimeMillis();
		return time2-time1;
	}

	
	public long sort() {
		// TODO Auto-generated method stub
		time1 = System.currentTimeMillis();
		Collections.sort(myArrayList);
		time2 = System.currentTimeMillis();
		return time1-time2;
	}

	
	public long get(int a) {
		// TODO Auto-generated method stub
		time1 = System.currentTimeMillis();
		Random rand = new Random();
		
		myArrayList.get(rand.nextInt(myArrayList.size()));
		time2 = System.currentTimeMillis();
		return time1-time2;
	}

	
	public long delete(int first, int second) {
		// TODO Auto-generated method stub
		time1 = System.currentTimeMillis();
		for (int i = first; i < second; i++) {
			myArrayList.remove(i);
		}
		time2 = System.currentTimeMillis();
		return time2-time1;
	}

	
	public String getCollectionName() {
		// TODO Auto-generated method stub
		return "arrayList";
	}

}
