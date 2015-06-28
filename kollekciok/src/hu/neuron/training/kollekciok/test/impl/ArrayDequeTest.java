package hu.neuron.training.kollekciok.test.impl;

import hu.neuron.training.kollekciok.test.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class ArrayDequeTest implements Test {
	protected static final int DEFAULT_SIZE = 1000000;
	protected Deque<Integer> szamok;
	protected int size;

	@Override
	public void init() {
		this.szamok = new ArrayDeque<Integer>();
		Random rnd = new Random();
		for (int i = 0; i < size; i++) {
			szamok.add(rnd.nextInt(size));
		}

	}

	@Override
	public void get(int n) {
		int elem;
		for (int i = 0; i < n; i++) {
			elem = szamok.getFirst();
		}

	}

	@Override
	public void delete(int startIndex, int n) {
		for (int i = startIndex; i < startIndex + n; i++) {
			szamok.remove(i);
		}

	}

	@Override
	public void sort() {
	}

	public ArrayDequeTest(int size) {
		super();
		this.size = size;
	}

	public ArrayDequeTest() {
		super();
		this.size = DEFAULT_SIZE;
	}
	
	

}
