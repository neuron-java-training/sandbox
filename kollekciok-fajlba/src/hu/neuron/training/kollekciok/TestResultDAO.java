package hu.neuron.training.kollekciok;

import hu.neuron.training.kollekciok.test.TestResult;

import java.util.List;

/**
 * Interfész teszteredmények perzisztens kezeléséhez.
 * 
 * @author Norbert
 * 
 */
public interface TestResultDAO {

	/**
	 * Metódus a beolvasáshoz valamilyen külsõ forrásból.
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
