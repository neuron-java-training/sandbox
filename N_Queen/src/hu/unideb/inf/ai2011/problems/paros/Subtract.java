package hu.unideb.inf.ai2011.problems.paros;

import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.State;

public class Subtract implements Operator {

	@Override
	public boolean isApplicable(State s) {
		if (!(s instanceof ParosState)) {
			return false;
		}
		
		ParosState ps = (ParosState)s;
		return ps.h[0] - ps.h[1] > 0;
	}

	@Override
	public State apply(State s) {
		ParosState ps = new ParosState((ParosState)s);
		ps.h[0] = ps.h[0] - ps.h[1];
		return ps;
	}

	@Override
	public String toString() {
		return "-";
	}
}
