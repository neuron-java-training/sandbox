package hu.unideb.inf.ai2011.problems.queen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import hu.unideb.inf.ai2011.Cost;
import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.algorithms.BackTrack;
import hu.unideb.inf.ai2011.algorithms.BreadthFirstSearch;
import hu.unideb.inf.ai2011.algorithms.OptimalSearch;
import hu.unideb.inf.ai2011.algorithms.TrialAndError;

public class Main {

	public static void main(String[] args) {

		List<Result> eredmenyek = new ArrayList<Result>();
		Date kezdes;
		Date befejezes;
		long ido;
		Problem problem = new QueenProblem(10);
		Cost cost = new QueenCost();

		// BackTrack kereső
		System.out.println("BackTrack");
		BackTrack algorithm2 = new BackTrack(problem);
		kezdes = new Date();
		algorithm2.run();
		System.out.println(algorithm2.getGoal());
		befejezes = new Date();
		ido = befejezes.getTime() - kezdes.getTime();
		eredmenyek.add(new Result("BackTrack", ido));
		algorithm2 = null;

		// Próba-hiba módszer
		System.out.println("TrialAndError");
		TrialAndError algorithm3 = new TrialAndError(problem);
		kezdes = new Date();
		algorithm3.run();
		System.out.println(algorithm3.getGoal());
		befejezes = new Date();
		ido = befejezes.getTime() - kezdes.getTime();
		eredmenyek.add(new Result("TrialAndError", ido));
		algorithm3 = null;

		// BreadthFirst kereső
		System.out.println("BreadthFirstSearch");
		BreadthFirstSearch algorithm4 = new BreadthFirstSearch(problem);
		kezdes = new Date();
		algorithm4.run();
		System.out.println(algorithm4.getGoal());
		befejezes = new Date();
		ido = befejezes.getTime() - kezdes.getTime();
		eredmenyek.add(new Result("BreadthFirstSearch", ido));
		algorithm4 = null;

		// Optimális kereső (0 költséggel)
		System.out.println("OptimalSearch");
		OptimalSearch algorithm = new OptimalSearch(problem, cost);
		kezdes = new Date();
		algorithm.run();
		System.out.println(algorithm.getGoal());
		befejezes = new Date();
		ido = befejezes.getTime() - kezdes.getTime();
		eredmenyek.add(new Result("OptimalSearch", ido));
		algorithm = null;

		// kiíratás
		Collections.sort(eredmenyek);
		for (Result r : eredmenyek) {
			System.out.println(r);
		}
	}

}
