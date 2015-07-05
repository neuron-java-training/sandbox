package hu.neuron.java.kollekcio_projekt.app;

import java.util.LinkedHashSet;
import java.util.Random;

/**
 * Osztály a {@code Set} interfész {@code LinkedHashSet} implementációja
 * teljesítményének vizsgálatához.
 * 
 * @author Norbert
 * 
 */
public class LinkedHashSetTest extends HashSetTest {

	@Override
	public void init() {
		this.szamok = new LinkedHashSet<Integer>();
		Random rnd = new Random();
		for (int i = 0; i < size; i++) {
			szamok.add(rnd.nextInt(size));
		}
	}

	public LinkedHashSetTest(int size) {
		super(size);
	}

	public LinkedHashSetTest() {
	}

}
