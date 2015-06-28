package hu.unideb.inf.ai2011.problems.paros;

import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.State;

public class Add implements Operator {

	@Override
	public boolean isApplicable(State s) {
		return s instanceof ParosState;
	}

	@Override
	public State apply(State s) {
		ParosState ps = new ParosState((ParosState)s);
		ps.h[0] += ps.h[1];
		return ps;
	}

	@Override
	public String toString() {
		return "+";
	}
}
