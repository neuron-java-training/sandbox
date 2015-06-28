package run;

import hu.unideb.inf.ai2011.problems.queen.QueenProblem;

public class Main {

	public static void main(String[] args) {
		QueenProblem p = new QueenProblem();
		Runner run = new Runner(p);
		run.run();

	}
}
