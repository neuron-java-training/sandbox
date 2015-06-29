package hu.unideb.inf.ai2011.problems.queen;

import hu.unideb.inf.ai2011.State;
import hu.unideb.inf.ai2011.algorithms.BackTrack;
import hu.unideb.inf.ai2011.algorithms.TrialAndError;
import hu.unideb.inf.ai2011.problems.jugs.JugProblem;

public class Main {

	public static void main(String[] args) {
		QueenProblem problem = new QueenProblem();
		BackTrack algorithm = new BackTrack(problem);
		algorithm.run();
		System.out.println(algorithm.getGoal());
		
		
	}

}
