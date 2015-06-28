package run;

import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.problems.queen.QueenProblem;

import java.util.ArrayList;
import java.util.List;

import algorithms.BackTrack;
import algorithms.BreadthFirstSearch;
import algorithms.Search;
import algorithms.TrialAndError;

public class Runner {
	Problem problem;
	
	List<Search> searchs = new ArrayList<>();
	public Runner(Problem p) {
		this.problem = p;
		searchs.add(new BackTrack(problem));
		searchs.add(new BreadthFirstSearch(problem));
		searchs.add(new TrialAndError(problem));
	}
	
	public void run() {
		for (Search search : searchs) {
			search.run();
			System.out.println(search.getClass());
			System.out.println(search.res());
		}
	}


}
