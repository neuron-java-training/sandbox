package hu.neuron.java.kollekcio_projekt.app;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class LinkedListDequeTest extends ArrayDequeTest {

	@Override
	public void init() {
		this.szamok = new LinkedList<Integer>();
		Random rnd = new Random();
		for (int i = 0; i < size; i++) {
			szamok.add(rnd.nextInt(size));
		}

	}

	@Override
	public void sort() {
		Collections.sort((List<Integer>) szamok);
	}

	public LinkedListDequeTest() {
		super();
	}

	public LinkedListDequeTest(int size) {
		super(size);
	}

}
