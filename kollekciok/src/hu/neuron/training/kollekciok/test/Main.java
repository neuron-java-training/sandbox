package hu.neuron.training.kollekciok.test;

import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		TestRunner tr = new TestRunner(200000, 6000);
		List<TestResult> vegeredmeny = tr.test();
		Collections.sort(vegeredmeny);

		System.out.println();
		for (TestResult trst : vegeredmeny) {
			System.out.println(trst);
		}

	}

}
