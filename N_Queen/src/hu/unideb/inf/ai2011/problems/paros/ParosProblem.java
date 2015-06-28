package hu.unideb.inf.ai2011.problems.paros;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.State;

public class ParosProblem implements Problem {
	private Set<Operator> operators;
	
	public ParosProblem() {
		operators = new HashSet<Operator>();
		operators.add(new Subtract());
		operators.add(new Add());
		operators.add(new Change());
	}
	
	@Override
	public State startState() {
		return new ParosState();
	}

	@Override
	public Collection<Operator> operators() {
		return operators;
	}

}
