package hu.neuron.training.kollekciok.test;

import hu.neuron.training.kollekciok.impl.TestResultAverageImpl;
import hu.neuron.training.kollekciok.impl.TestResultDAOFileImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	private static final int futas = 5;

	public static void main(String[] args) {
		TestRunner tr;
		List<TestResult> vegeredmeny;
		TestResultDAOFileImpl fajlkezelo = new TestResultDAOFileImpl();
		for (int i = 1; i <= futas; i++) {
			tr = new TestRunner(10000, 1000);
			vegeredmeny = tr.test();
			Collections.sort(vegeredmeny);

			fajlkezelo.setFileName("output" + i + ".txt");
			fajlkezelo.write(vegeredmeny);
			System.out.println();
		}
		List<List<TestResult>> osszes = new ArrayList<>();

		for (int i = 1; i <= futas; i++) {
			fajlkezelo.setFileName("output" + i + ".txt");
			osszes.add(fajlkezelo.read());
		}
		TestResultAverageImpl atlagolo = new TestResultAverageImpl();
		List<TestResult> atlag = atlagolo.getAverage(osszes);
		Collections.sort(atlag);
		fajlkezelo.setFileName("average.txt");
		fajlkezelo.write(atlag);
	}

}
