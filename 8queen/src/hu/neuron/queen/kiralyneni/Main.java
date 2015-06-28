package hu.neuron.queen.kiralyneni;

import hu.neuron.queen.algorithm.BackTrack;
import hu.neuron.queen.algorithm.BreadthFirstSearch;
import hu.neuron.queen.algorithm.TrialAndError;

public class Main
{

	private static long start = 0;
	private static long end = 0;

	public static void main(String[] args)
	{
		QueenProblem problem = new QueenProblem();

		BackTrack backTrack = new BackTrack(problem);
		start = System.currentTimeMillis();
		backTrack.run();
		end = System.currentTimeMillis();
		System.out.println(backTrack.getGoal() + " " + (end - start) + "ms " + backTrack.lepes
				+ " lépés");

		BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(problem);
		start = System.currentTimeMillis();
		breadthFirstSearch.run();
		end = System.currentTimeMillis();
		System.out.println(breadthFirstSearch.getGoal() + " " + (end - start) + "ms "
				+ breadthFirstSearch.lepes + " lépés");

		TrialAndError trialAndError = new TrialAndError(problem);
		start = System.currentTimeMillis();
		trialAndError.run();
		end = System.currentTimeMillis();
		System.out.println(trialAndError.getGoal() + " " + (end - start) + "ms "
				+ trialAndError.lepes + " lépés");

	}
}
