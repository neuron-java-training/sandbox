package hu.unideb.inf.ai2011.problems.jugs;

import java.util.HashSet;
import java.util.Set;

import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.State;

public class JugProblem implements Problem {

	static HashSet<Operator> operators = new HashSet<Operator>();
	static {
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				if (i != j) {
					operators.add(new JugOperator(i, j));
				}
			}
		}
//		operators.add( new JugOperator(1,2) );
//		operators.add( new JugOperator(1,3) );
//		operators.add( new JugOperator(2,1) );
//		operators.add( new JugOperator(2,3) );
//		operators.add( new JugOperator(3,1) );
//		operators.add( new JugOperator(3,2) );
	}
	
	@Override
	public Set<Operator> operators() {
		return operators;
	}

	@Override
	public State startState() {
		return new JugState(5,0,0);
	}
	
}
