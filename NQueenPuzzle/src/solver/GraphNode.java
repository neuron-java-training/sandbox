package solver;

import queenPuzzle.Operator;
import queenPuzzle.State;

public class GraphNode extends Node{

	private GraphNode parent = null;
	
	public GraphNode(State initialState) {
		super(initialState);
		
	}

	public GraphNode(State state, Operator producerOperator, GraphNode parent) {
		super(state, producerOperator);
		this.parent = parent;
	}

	public GraphNode getParent() {
		return parent;
	}

	public void setParent(GraphNode parent) {
		this.parent = parent;
	}
	
}
