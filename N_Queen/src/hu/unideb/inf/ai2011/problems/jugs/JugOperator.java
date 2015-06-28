package hu.unideb.inf.ai2011.problems.jugs;

import hu.unideb.inf.ai2011.CostOperator;
import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.State;

public class JugOperator implements Operator, CostOperator {

	int source;
	
	int target;
	
	public JugOperator(int source, int target) {
		super();
		this.source = source;
		this.target = target;
	}

	public int movedWater( JugState state ) {
		int available = 0;
		switch ( source ) {
		case 1: available = state.water1; break;
		case 2: available = state.water2; break;
		case 3: available = state.water3; break;
		}
		int free = 0;
		switch ( target ) {
		case 1: free = 5 - state.water1; break;
		case 2: free = 3 - state.water2; break;
		case 3: free = 2 - state.water3; break;
		}
		return Math.min(available, free);
	}
	
	public boolean isApplicable( State arg0 ) {
		JugState state = (JugState)arg0;
		return movedWater(state) > 0;
	}
	
	public State apply( State arg0 ) {
		JugState state = (JugState)arg0;
		int w1 = state.water1;
		int w2 = state.water2;
		int w3 = state.water3;
		int move = movedWater(state);
		
		switch ( source ) {
		case 1: w1 = w1 - move; break;
		case 2: w2 = w2 - move; break;
		case 3: w3 = w3 - move; break;
		}

		switch ( target ) {
		case 1: w1 = w1 + move; break;
		case 2: w2 = w2 + move; break;
		case 3: w3 = w3 + move; break;
		}

		return new JugState(w1, w2, w3);
	}
	
	@Override
	public String toString() {
		return source + " -> " + target; 
	}

	@Override
	public double cost(State state) {
		return state instanceof JugState ? (double)this.movedWater((JugState)state) : 1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + source;
		result = prime * result + target;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof JugOperator)) {
			return false;
		}
		JugOperator other = (JugOperator) obj;
		if (source != other.source) {
			return false;
		}
		if (target != other.target) {
			return false;
		}
		return true;
	}
	
}
