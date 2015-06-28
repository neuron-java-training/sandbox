package hu.unideb.inf.ai2011.problems.paros;

import java.util.Arrays;

import hu.unideb.inf.ai2011.HeuristicState;
import hu.unideb.inf.ai2011.State;

public class ParosState implements State, HeuristicState {
	int h[];
	
	public ParosState() {
		this.h = new int[]{ 155, 45 };
	}
	
	public ParosState(ParosState fs) {
		this.h = new int[2];
		this.h[0] = fs.h[0];
		this.h[1] = fs.h[1];
	}
	
	@Override
	public boolean isGoal() {
		return h[0] == 10 && h[1] == 75;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ParosState)) {
			return false;
		}
		ParosState other = (ParosState) obj;
		if (!Arrays.equals(h, other.h)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return h[0] + " " + h[1];
	}

	@Override
	public double heuristic() {
		return h[0] + h[1];
	}
}
