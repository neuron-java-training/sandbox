package hu.unideb.inf.ai2011.problems.jugs;

import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.algorithms.*;

/**
 * @author kadekta
 *
 */
public class Main {

	public static void main( String[] args ) {
		Problem problem = new JugProblem();

//		TrialAndError algorithm = new TrialAndError(problem);
//		BackTrack algorithm = new BackTrack(problem);
//		BoundedBackTrack algorithm = new BoundedBackTrack(problem, 9);		
		HillClimbing algorithm = new HillClimbing(problem);
//		BranchAndBound algorithm = new BranchAndBound(problem, 15);
//		DepthFirst algorithm = new DepthFirst(problem);
//		BreadthFirst algorithm = new BreadthFirst(problem);
//		Optimal algorithm = new Optimal(problem);
//		BestFirst algorithm = new BestFirst(problem);
//		ABasic algorithm = new ABasic(problem);
		algorithm.run();
//		System.out.println(algorithm.getSolution());
//		algorithm.printSolution();
//		System.out.println( algorithm.getGoal() );
	}
	
}
