package solver;

import java.util.List;

import queenPuzzle.Operator;
import queenPuzzle.StateSpace;

public abstract class QueenPuzzleSolver {

	private String solverName = null;
	
	public QueenPuzzleSolver(String solverName) {
		super();
		this.solverName = solverName;
	}

	public abstract List<Operator> search(StateSpace stateSpace);

	public String getSolverName() {
		return solverName;
	}
	
	
}
