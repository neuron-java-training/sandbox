package hu.unideb.inf.ai2011.problems.four;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.State;

public class FourProblem implements Problem {
	private Set<Operator> operators;
	
	public FourProblem() {
		operators = new HashSet<Operator>();
		operators.add(new AppendZero());
		operators.add(new AppendFour());
		operators.add(new Divide());
	}
	
	@Override
	public State startState() {
		return new FourState();
	}

	@Override
	public Collection<Operator> operators() {
		return operators;
	}

}
