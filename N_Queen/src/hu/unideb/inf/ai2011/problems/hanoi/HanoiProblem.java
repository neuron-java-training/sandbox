package hu.unideb.inf.ai2011.problems.hanoi;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.State;

public class HanoiProblem implements Problem {

	private Set<Operator> operators;

	public HanoiProblem() {
		operators = new HashSet<Operator>();
		operators.add( new HanoiOperator(1,2) );
		operators.add( new HanoiOperator(1,3) );
		operators.add( new HanoiOperator(2,1) );
		operators.add( new HanoiOperator(2,3) );
		operators.add( new HanoiOperator(3,1) );
		operators.add( new HanoiOperator(3,2) );
	}
	
	@Override
	public Collection<Operator> operators() {
		return operators;
	}

	@Override
	public State startState() {
		return new HanoiState();
	}

	
	
}
