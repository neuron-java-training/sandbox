package hu.neuron.java.core;


import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Tester <T extends List<ComparableItem>> implements Test {
	
	T t;
	ComparableItem item =  new ComparableItem();
	private int time1;
	private int time2;
	private int  dif;
	
	
	public int init() {
		time1 =  (int) System.currentTimeMillis(); 
		for (int i = 0; i < 1000000; i++) {
			
			
			
		t.add(item);
		}
		time2 =  (int) System.currentTimeMillis();
		
		dif = time2-time1;
		
		return dif;
	}

	public Tester(T t) {
		super();
		this.t = t;
	}


	
	public int sort() {
		// TODO Auto-generated method stub
		time1 = (int) System.currentTimeMillis(); 
		Collections.sort(t);
		time2 = (int) System.currentTimeMillis(); 
		
		dif = time2-time1;
		
		return dif;
	}

	
	public int getRand(int s) {
		
		Random rand = new Random();
		time1 =  (int) System.currentTimeMillis(); 
		for (int i = 0; i < s; i++) {
			
			t.get(rand.nextInt(t.size()));
			
		}
		
		time2 =  (int) System.currentTimeMillis(); 
		dif = time2-time1;
		return dif;
		
	}

	
	public int delete(int s, int e) {
		time1 =  (int) System.currentTimeMillis(); 
		for (int i = s; i < e; i++) {
			t.remove(i);
			
		}
		time2 =  (int) System.currentTimeMillis();
		dif = time2-time1;
		
		return dif;
		
	}

}
