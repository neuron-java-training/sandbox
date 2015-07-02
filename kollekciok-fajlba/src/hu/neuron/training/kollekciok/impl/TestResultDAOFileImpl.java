package hu.neuron.training.kollekciok.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hu.neuron.training.kollekciok.TestResultDAO;
import hu.neuron.training.kollekciok.test.TestResult;

/**
 * Osztály tesztadatok fájlba történõ írásához, illetve fájlból történõ
 * olvasásához.
 * 
 * @author Norbert
 * 
 */
public class TestResultDAOFileImpl implements TestResultDAO {

	/**
	 * Adattag a forrás iletve cél megadásához.
	 */
	private String fileName;

	/**
	 * Lekérdezõ metódus a fájlnévhez.
	 * 
	 * @return A fájlnevet adja vissza.
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Metódus a fájlnév beállításához.
	 * 
	 * @param fileName
	 *            A beállítandó fájl neve.
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Metódus tesztadatok fájlból olvasásához.
	 * 
	 * @return Ha van teszt eredmény, akkor {@code List<TestResult>} típusú
	 *         listával tér vissza, különben {@code null} értékkel.
	 */
	@Override
	public List<TestResult> read() {
		try (Scanner sc = new Scanner(new FileInputStream(fileName))) {
			List<TestResult> lista = new ArrayList<>();
			String sor;
			while (sc.hasNextLine()) {
				sor = sc.nextLine();
				String[] temp = sor.split(" ");
				lista.add(new TestResult(temp[0], Integer.parseInt(temp[1])));
			}
			return lista;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Metódus tesztadatok fájlba történõ írásához.
	 * 
	 * @param eredmeny
	 *            A teszteredmények listája.
	 * 
	 */
	@Override
	public void write(List<TestResult> eredmeny) {
		if (eredmeny == null) {
			return;
		}
		try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName))) {
			for (TestResult tr : eredmeny) {
				writer.println(tr.toString());
				writer.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Konstruktor egy {@code TestResultDAOFileImpl} objektum létrehozásához.
	 * 
	 * @param fileName
	 *            paraméter a forrás/cél fájlnév megadásához.
	 */
	public TestResultDAOFileImpl(String fileName) {
		super();
		this.fileName = fileName;
	}

	/**
	 * Paraméter nélküli konstruktor egy {@code TestResultDAOFileImpl} objektum
	 * létrehozásához.
	 */
	public TestResultDAOFileImpl() {
		super();
	}

}
