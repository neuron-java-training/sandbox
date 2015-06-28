package hu.unideb.inf.ai2011.problems.queen;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.State;

public class QueenProblem implements Problem {

	static Set<Operator> operators = new HashSet<Operator>();
	static {
		operators.add( new QueenOperator(1) );
		operators.add( new QueenOperator(2) );
		operators.add( new QueenOperator(3) );
		operators.add( new QueenOperator(4) );
		operators.add( new QueenOperator(5) );
		operators.add( new QueenOperator(6) );
		operators.add( new QueenOperator(7) );
		operators.add( new QueenOperator(8) );
	}
	
	
	@Override
	public Collection<Operator> operators() {
		return operators;
	}

	@Override
	public State startState() {
		return new QueenState();
	}

}
