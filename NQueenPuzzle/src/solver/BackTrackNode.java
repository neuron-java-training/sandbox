package solver;

import java.util.ArrayList;
import java.util.List;

import queenPuzzle.Operator;
import queenPuzzle.State;
import queenPuzzle.StateSpace;

public class BackTrackNode extends Node {

	private List<Operator> untried = null;

	public BackTrackNode(State state, Operator producerOperator, StateSpace stateSpace) {
		super(state, producerOperator);
		this.untried = new ArrayList<Operator>();
		for (Operator op : stateSpace.getListOfOperators())
			if (op.isApplicable(state)) {
				untried.add(op);
			}
	}

	public List<Operator> getUntried() {
		return untried;
	}

	public void setUntried(List<Operator> untried) {
		this.untried = untried;
	}
	
	
}
