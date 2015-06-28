package hu.unideb.inf.ai2011.problems.four;

import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.State;

public class Divide implements Operator {

	@Override
	public boolean isApplicable(State s) {
		if (s instanceof FourState) {
			FourState state = (FourState) s;
			return state.h % 2 == 0;
		}
		return false;
	}

	@Override
	public State apply(State s) {
		FourState fs = new FourState((FourState)s);
		fs.h /= 2;
		return fs;
	}

	@Override
	public String toString() {
		return "2";
	}
}
