package hu.neuron.java.kollekcio_projekt.app;

import java.util.LinkedList;
import java.util.Random;

/**
 * Osztály a {@code List} interfész {@code LinkedList} implementációja
 * teljesítményének vizsgálatához.
 * 
 * @author Norbert
 * 
 */
public class LinkedListTest extends ArrayListTest {

	@Override
	public void init() {
		this.szamok = new LinkedList<Integer>();
		Random rnd = new Random();
		for (int i = 0; i < size; i++) {
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
