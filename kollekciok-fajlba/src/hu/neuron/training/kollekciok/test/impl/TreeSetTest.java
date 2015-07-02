package hu.neuron.training.kollekciok.test.impl;

import java.util.Random;
import java.util.TreeSet;

public class TreeSetTest extends HashSetTest {

	@Override
	public void init() {
		this.szamok = new TreeSet<Integer>();
		Random rnd = new Random();
		for (int i = 0; i < size; i++) {
			szamok.add(rnd.nextInt(size));
		}
	}

	public TreeSetTest(int size) {
		super(size);
	}

	public TreeSetTest() {
		super();
	}

}
