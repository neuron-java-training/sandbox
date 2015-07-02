package hu.neuron.training.kollekciok;

import hu.neuron.training.kollekciok.test.TestResult;

import java.util.List;

/**
 * Interf�sz teszteredm�nyek perzisztens kezel�s�hez.
 * 
 * @author Norbert
 * 
 */
public interface TestResultDAO {

	/**
	 * Met�dus a beolvas�shoz valamilyen k�ls� forr�sb�l.
	 * 
	 * @return A beolvasott teszteredm�nyek list�j�val t�r vissza.
	 */
	public List<TestResult> read();

	/**
	 * Met�dus teszteredm�nyek perzisztens t�rol�s�hoz.
	 * 
	 * @param eredmeny
	 *            A teszteredm�nyek list�ja.
	 */
	public void write(List<TestResult> eredmeny);

}
