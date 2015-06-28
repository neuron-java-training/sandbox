package hu.unideb.inf.ai2011.problems.jugs;

import hu.unideb.inf.ai2011.HeuristicState;
import hu.unideb.inf.ai2011.State;

public class JugState implements State, HeuristicState {
	
	/** water in the 1st jug (max 5) */
	int water1;
	
	/** water in the 2nd jug (max 3) */
	int water2;
	
	/** water in the 3rd jug (max 2)*/
	int water3;

	public JugState(int water1, int water2, int water3) {
		this.water1 = water1;
		this.water2 = water2;
		this.water3 = water3;
	}
	
	public boolean isGoal() {
		return water1 == 4;
	}
	
	@Override
	public String toString() {
		return "("+water1+","+water2+","+water3+")";
	}

	@Override
	public boolean equals( Object arg0 ) {
		if ( arg0 == null || !(arg0 instanceof JugState))
			return false;
		JugState state = (JugState)arg0;
		return 
			state.water1 == this.water1 &&
			state.water2 == this.water2 &&
			state.water3 == this.water3;
	}
	
	@Override
	public double heuristic() {
		if (this.isGoal()) {
			return 0;
		}
		int i = 0;
		if (this.water1 > 0) ++i;
		if (this.water2 > 0) ++i;
		if (this.water3 > 0) ++i;
//		return 5 - (this.water3+ this.water2);
		return 4 - i;
//		return i;
//		return Math.abs(4-this.water1);
	}
}
