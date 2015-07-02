package hu.neuron.training.kollekciok.test.impl;

import java.util.LinkedList;
import java.util.Random;

public class LinkedListTest extends ArrayListTest {

	@Override
	public void init() {
		this.szamok = new LinkedList<Integer>();
		Random rnd = new Random();
		for(int i=0; i < size; i++){
			szamok.add(rnd.nextInt(size));
		}
	}

	public LinkedListTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LinkedListTest(int size) {
		super(size);
		// TODO Auto-generated constructor stub
	}

	
	
	

}
