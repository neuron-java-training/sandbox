package hu.neuron.feladat.colltester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ArrayTester implements Test {

	List<Item> list =  new ArrayList<Item>();
	int size;
	Date time = new Date();
	long time1;
	long time2;
	long dif;
	
	
	public ArrayTester(int size){
		
		this.size = size;
		
		System.out.println("ArrayList : ");
		
	}
	public ArrayTester() {
		super();
		System.out.println("ArrayList : ");
	}

	
	
	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}




	@Override
	public void init() {
		
		
		time1 = System.currentTimeMillis();
		
		for(int i = 0;i<size;++i){
			
			list.add(new Item(i));
			
		}
		
		time2 = System.currentTimeMillis();
		
		dif = time2-time1;
		
		System.out.println("Fill time : " + dif);

		
		
	}

	

	

	@Override
	public void sort() {
		time1 = System.currentTimeMillis();
		Collections.sort(list);

		time2 = System.currentTimeMillis();
		
		dif = time2-time1;
		
		System.out.println("Sort time : " + dif);
		
	}

	@Override
	public void getRand(int s) {
		time1 = System.currentTimeMillis();
		for (int i = 0; i < s; i++) {
			
			Random rand = new Random();
			
			list.get(rand.nextInt(list.size()));
			
			
		}
		
		
		time2 = System.currentTimeMillis();
		
		dif = time2-time1;
		
		System.out.println("Insert time : "+dif);
		
	}

	@Override
	public void delete(int s, int e) {
		
		time1 = System.currentTimeMillis();
		for (int i = s; i < e; i++) {
			
			list.remove(i);	
			
		}
		
		time2 = System.currentTimeMillis();
		
		dif = time2-time1;
		
		System.out.println("Remove time : "+dif);
	}

}
