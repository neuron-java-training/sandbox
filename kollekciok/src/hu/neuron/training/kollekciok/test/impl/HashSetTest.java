package hu.neuron.training.kollekciok.test.impl;

import hu.neuron.training.kollekciok.test.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HashSetTest implements Test {
	protected static final int DEFAULT_SIZE = 1000000;
	protected Set<Integer> szamok;
	protected int size;

	@Override
	public void init() {
		this.szamok = new HashSet<Integer>();
		Random rnd = new Random();
		for (int i = 0; i < size; i++) {
			szamok.add(rnd.nextInt(size));
		}
	}

	@Override
	public void get(int n) {
		boolean elem;
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			elem = szamok.contains(r.nextInt(szamok.size()));
		}
	}

	@Override
	public void delete(int startIndex, int n) {
		boolean torolve;
		for (int i = startIndex; i < startIndex + n; i++) {
			torolve = szamok.remove(i);
		}
	}

	@Override
	public void sort() {
	}

	public HashSetTest(int size) {
		super();
		this.size = size;
	}

	public HashSetTest() {
		super();
		this.size = DEFAULT_SIZE;
	}

}
