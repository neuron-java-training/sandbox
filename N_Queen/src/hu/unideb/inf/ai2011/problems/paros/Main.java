package hu.unideb.inf.ai2011.problems.paros;

import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.algorithms.BestFirst;
import hu.unideb.inf.ai2011.algorithms.BreadthFirst;
import hu.unideb.inf.ai2011.algorithms.DepthFirst;
public class Main {

	public static void main(String[] args) {
		Problem problem = new ParosProblem();

//		TrialAndError algorithm = new TrialAndError(problem);
//		BackTrack algorithm = new BackTrack(problem);
//		BoundedBackTrack algorithm = new BoundedBackTrack(problem, 4);		
//		HillClimbing algorithm = new HillClimbing(problem);
//		BranchAndBound algorithm = new BranchAndBound(problem, 40);
//		DepthFirst algorithm = new DepthFirst(problem);
//		BreadthFirst algorithm = new BreadthFirst(problem);
//		Optimal algorithm = new Optimal(problem);
		BestFirst algorithm = new BestFirst(problem);
//		ABasic algorithm = new ABasic(problem);
		algorithm.run();
	}

}
