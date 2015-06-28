package hu.unideb.inf.ai2011.problems.four;

import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.State;

public class AppendZero implements Operator {

	@Override
	public boolean isApplicable(State s) {
		return true;
	}

	@Override
	public State apply(State s) {
		FourState fs = new FourState((FourState)s);
		fs.h *= 10;
		return fs;
	}

	@Override
	public String toString() {
		return "0";
	}
}
