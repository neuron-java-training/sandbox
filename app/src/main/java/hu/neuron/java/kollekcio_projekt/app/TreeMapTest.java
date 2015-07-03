package hu.neuron.java.kollekcio_projekt.app;

import java.util.Random;
import java.util.TreeMap;

public class TreeMapTest extends HashMapTest{

	@Override
	public void init() {
		this.szamok = new TreeMap<Integer, Integer>();
		Random rnd = new Random();
		for (int i = 0; i < size; i++) {
			szamok.put(i, rnd.nextInt(size));
		}
	}

	public TreeMapTest() {
		super();
	}

	public TreeMapTest(int size) {
		super(size);
	}

}
