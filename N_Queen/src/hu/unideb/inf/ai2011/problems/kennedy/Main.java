package hu.unideb.inf.ai2011.problems.kennedy;

import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.algorithms.ABasic;

public class Main {

	public static void main(String[] args) {
		Problem problem = new KennedyProblem();
		ABasic algorithm = new ABasic(problem);
		algorithm.run();
		System.out.print(algorithm.getGoal());
	}

}
