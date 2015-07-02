package hu.neuron.training.kollekciok.test.impl;

import hu.neuron.training.kollekciok.test.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ArrayListTest implements Test {
	protected static final int DEFAULT_SIZE = 1000000;
	protected List<Integer> szamok;
	protected int size;
	
	@Override
	public void init() {
		this.szamok = new ArrayList<Integer>();
		Random rnd = new Random();
		for(int i=0; i < size; i++){
			szamok.add(rnd.nextInt(size));
		}

	}
	@Override
	public void sort() {
		Collections.sort(szamok);
	}

	@Override
	public void get(int n) {
		int elem;
		Random r = new Random();
		for(int i = 0; i< n; i++){
			elem = szamok.get(r.nextInt(szamok.size()));
		}
	}

	@Override
	public void delete(int startIndex, int n) {
		for (int i = startIndex; i < startIndex + n; i++) {
			szamok.remove(startIndex);
		}
	}
	public ArrayListTest(int size) {
		super();
		this.size = size;
	}
	
	public ArrayListTest() {
		this.size = DEFAULT_SIZE;
	}
	
	

}
