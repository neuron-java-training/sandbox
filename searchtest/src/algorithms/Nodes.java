package algorithms;

import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.State;

public abstract class Nodes {
	
	protected State state;
	protected Operator op;
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public Operator getOp() {
		return op;
	}
	public void setOp(Operator op) {
		this.op = op;
	}
	public Nodes(State state, Operator op) {
		super();
		this.state = state;
		this.op = op;
	}
	
	

}
