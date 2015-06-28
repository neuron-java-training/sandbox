package hu.unideb.inf.ai2011.problems.paros;

import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.State;

public class Change implements Operator {

	@Override
	public boolean isApplicable(State s) {
		return s instanceof ParosState;
	}

	@Override
	public State apply(State s) {
		ParosState ps = new ParosState((ParosState)s);
		int temp = ps.h[0];
		ps.h[0] = ps.h[1];
		ps.h[1] = temp;
		return ps;
	}

	@Override
	public String toString() {
		return "x";
	}
}
