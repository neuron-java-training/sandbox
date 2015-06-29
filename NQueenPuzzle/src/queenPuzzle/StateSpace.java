package queenPuzzle;

import java.util.ArrayList;
import java.util.List;

public class StateSpace {

	private State state = null;
	private List<Operator> listOfOperators = null;
	private int n = 0;
	
	public StateSpace(int n) {
		super();
		this.n = n;
		this.state = new State(n);
		this.listOfOperators = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				listOfOperators.add(new Operator(i, j));
			}
		}
	}
	
	public State initialState(){
		return new State(n);
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<Operator> getListOfOperators() {
		return listOfOperators;
	}

	public void setListOfOperators(List<Operator> listOfOperators) {
		this.listOfOperators = listOfOperators;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}	
}
