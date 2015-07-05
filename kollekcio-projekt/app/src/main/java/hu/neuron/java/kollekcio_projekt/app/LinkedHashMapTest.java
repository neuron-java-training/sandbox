package hu.neuron.java.kollekcio_projekt.app;

import java.util.LinkedHashMap;
import java.util.Random;

/**
 * Osztály a {@Map} interfész {@code LinkedHashMap} implementációja
 * teljesítményének vizsgálatához.
 * 
 * @author Norbert
 * 
 */
public class LinkedHashMapTest extends HashMapTest {

	@Override
	public void init() {
		this.szamok = new LinkedHashMap<Integer, Integer>();
		Random rnd = new Random();
		for (int i = 0; i < size; i++) {
			szamok.put(i, rnd.nextInt(size));
		}
	}

	public LinkedHashMapTest(int size) {
		super(size);
	}

	public LinkedHashMapTest() {
	}

}
