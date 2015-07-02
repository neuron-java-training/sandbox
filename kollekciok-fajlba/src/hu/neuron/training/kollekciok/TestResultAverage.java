package hu.neuron.training.kollekciok;

import hu.neuron.training.kollekciok.test.TestResult;

import java.util.List;

/**
 * Interf�sz teszteredm�nyek �tlagol�s�hoz.
 * @author Norbert
 *
 */
public interface TestResultAverage {
	
	/**
	 * Met�dus r�szeredm�nyek �tlagol�s�hoz.
	 * @param eredmenyLista a r�szeredm�nyek list�it tartalamazza.
	 * @return Az �tlagolt r�szeredm�nyek list�j�val t�r vissza.
	 */
	public List<TestResult> getAverage(List<List<TestResult>> eredmenyLista);

}
