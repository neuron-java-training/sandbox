package hu.neuron.java.kollekcio_projekt.app;

import hu.neuron.java.kollekcio_projekt.common.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HashMapTest implements Test {
	protected static final int DEFAULT_SIZE = 1000000;
	protected Map<Integer, Integer> szamok;
	protected int size;

	@Override
	public void init() {
		this.szamok = new HashMap<Integer, Integer>();
		Random rnd = new Random();
		for (int i = 0; i < size; i++) {
			szamok.put(i, rnd.nextInt(size));
		}

	}

	@Override
	public void get(int n) {
		int elem;
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			elem = szamok.get(r.nextInt(szamok.size()));
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

	public HashMapTest(int size) {
		super();
		this.size = size;
	}

	public HashMapTest() {
		super();
		this.size = DEFAULT_SIZE;
	}

}
