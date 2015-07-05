package hu.neuron.java.kollekcio_projekt.app;

import hu.neuron.java.kollekcio_projekt.common.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Osztály a {@code List} interfész {@code ArrayList} implementációja
 * teljesítményének vizsgálatához.
 * 
 * @author Norbert
 * 
 */
public class ArrayListTest implements Test {
	protected static final int DEFAULT_SIZE = 1000000;
	protected List<Integer> szamok;
	protected int size;

	/**
	 * Inicializáló metódus. Példányosítja, és feltölti a listát.
	 */
	@Override
	public void init() {
		this.szamok = new ArrayList<Integer>();
		Random rnd = new Random();
		for (int i = 0; i < size; i++) {
			szamok.add(rnd.nextInt(size));
		}

	}

	/**
	 * Metódus a lista rendezéséhez.
	 */
	@Override
	public void sort() {
		Collections.sort(szamok);
	}

	@Override
	public void get(int n) {
		int elem;
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			elem = szamok.get(r.nextInt(szamok.size()));
		}
	}

	/**
	 * Metódus a lista elemeinek törléséhez.
	 */
	@Override
	public void delete(int startIndex, int n) {
		for (int i = startIndex; i < startIndex + n; i++) {
			szamok.remove(startIndex);
		}
	}

	/**
	 * Konstruktor az osztály példányosításához.
	 * 
	 * @param size
	 *            Az elemek száma.
	 */
	public ArrayListTest(int size) {
		super();
		this.size = size;
	}

	/**
	 * Paraméter nélküli metódus az osztály példányosításához.
	 */
	public ArrayListTest() {
		this.size = DEFAULT_SIZE;
	}

}
