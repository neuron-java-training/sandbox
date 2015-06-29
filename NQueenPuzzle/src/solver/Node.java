package solver;

import queenPuzzle.Operator;
import queenPuzzle.State;

public abstract class Node {

	private State state = null;
	private Operator producerOperator = null;
	
	public Node(State initialState) {
		super();
		this.state = initialState;
	}

	public Node(State state, Operator producerOperator) {
		super();
		this.state = state;
		this.producerOperator = producerOperator;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Operator getProducerOperator() {
		return producerOperator;
	}

	public void setProducerOperator(Operator producerOperator) {
		this.producerOperator = producerOperator;
	}
}
