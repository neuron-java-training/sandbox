package hu.neuron.java.kollekcio_projekt.common;

import java.util.List;



/**
 * Interfész teszteredmények perzisztens kezeléséhez.
 * 
 * @author Norbert
 * 
 */
public interface TestResultDAO {

	/**
	 * Metódus a beolvasáshoz valamilyen külső forrásból.
	 * 
	 * @return A beolvasott teszteredmények listájával tér vissza.
	 */
	public List<TestResult> read();

	/**
	 * Metódus teszteredmények perzisztens tárolásához.
	 * 
	 * @param eredmeny
	 *            A teszteredmények listája.
	 */
	public void write(List<TestResult> eredmeny);

}
