package hu.neuron.training.kollekciok;

import hu.neuron.training.kollekciok.test.TestResult;

import java.util.List;

/**
 * Interfész teszteredmények átlagolásához.
 * @author Norbert
 *
 */
public interface TestResultAverage {
	
	/**
	 * Metódus részeredmények átlagolásához.
	 * @param eredmenyLista a részeredmények listáit tartalamazza.
	 * @return Az átlagolt részeredmények listájával tér vissza.
	 */
	public List<TestResult> getAverage(List<List<TestResult>> eredmenyLista);

}
