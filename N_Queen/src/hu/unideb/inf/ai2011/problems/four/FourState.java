package hu.unideb.inf.ai2011.problems.four;

import hu.unideb.inf.ai2011.HeuristicState;
import hu.unideb.inf.ai2011.State;

public class FourState implements State, HeuristicState {
	int h;
	
	public FourState() {
		this.h = 4;
	}
	
	public FourState(FourState fs) {
		this.h = fs.h;
	}
	
	@Override
	public boolean isGoal() {
		return h == 2012;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof FourState)) {
			return false;
		}
		FourState other = (FourState) obj;
		if (h != other.h) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return Integer.toString(h);
	}

	@Override
	public double heuristic() {
		return h;
	}
}
