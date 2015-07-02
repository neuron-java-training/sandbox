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
 * Oszt�ly tesztadatok f�jlba t�rt�n� �r�s�hoz, illetve f�jlb�l t�rt�n�
 * olvas�s�hoz.
 * 
 * @author Norbert
 * 
 */
public class TestResultDAOFileImpl implements TestResultDAO {

	/**
	 * Adattag a forr�s iletve c�l megad�s�hoz.
	 */
	private String fileName;

	/**
	 * Lek�rdez� met�dus a f�jln�vhez.
	 * 
	 * @return A f�jlnevet adja vissza.
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Met�dus a f�jln�v be�ll�t�s�hoz.
	 * 
	 * @param fileName
	 *            A be�ll�tand� f�jl neve.
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Met�dus tesztadatok f�jlb�l olvas�s�hoz.
	 * 
	 * @return Ha van teszt eredm�ny, akkor {@code List<TestResult>} t�pus�
	 *         list�val t�r vissza, k�l�nben {@code null} �rt�kkel.
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
	 * Met�dus tesztadatok f�jlba t�rt�n� �r�s�hoz.
	 * 
	 * @param eredmeny
	 *            A teszteredm�nyek list�ja.
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
	 * Konstruktor egy {@code TestResultDAOFileImpl} objektum l�trehoz�s�hoz.
	 * 
	 * @param fileName
	 *            param�ter a forr�s/c�l f�jln�v megad�s�hoz.
	 */
	public TestResultDAOFileImpl(String fileName) {
		super();
		this.fileName = fileName;
	}

	/**
	 * Param�ter n�lk�li konstruktor egy {@code TestResultDAOFileImpl} objektum
	 * l�trehoz�s�hoz.
	 */
	public TestResultDAOFileImpl() {
		super();
	}

}
