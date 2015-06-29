package runner;

import java.util.ArrayList;
import java.util.List;

import queenPuzzle.StateSpace;
import solver.BackTrack;
import solver.BreadthFirstSearch;
import solver.DeptFirstSearch;
import solver.QueenPuzzleSolver;

public class Runner {

	private List<QueenPuzzleSolver> solvers = null;
	private List<Solution> solutions = null;
	private StateSpace stateSpace = null;

	public Runner(StateSpace stateSpace) {
		super();	
		this.stateSpace = stateSpace;
		this.solutions = new ArrayList<>();
		this.solvers = new ArrayList<>();
	}

	public void addSolver(QueenPuzzleSolver solver) {
		this.solvers.add(solver);
	}
	
	public void run(){
		for (QueenPuzzleSolver solver : solvers) {
			solutions.add(new Solution(solver.search(stateSpace), solver.getSolverName()));
		}
	}
	
	public void printSolutionTables(){
		for (Solution solution : solutions) {
			System.out.println(solution.getName() + ":");
			solution.printSolutionTable();
		}
	}
	
	public static void main(String[] args) {
		Runner runner = new Runner(new StateSpace(8));
		runner.addSolver(new DeptFirstSearch());
		//runner.addSolver(new BreadthFirstSearch());
		runner.addSolver(new BackTrack());
		
		runner.run();
		
		runner.printSolutionTables();
	}
	
	
}
