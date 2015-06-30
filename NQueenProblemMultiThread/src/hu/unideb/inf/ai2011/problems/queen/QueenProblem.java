package hu.unideb.inf.ai2011.problems.queen;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.State;

public class QueenProblem implements Problem {

	private Set<Operator> operators;
	private int size;

	@Override
	public Collection<Operator> operators() {
		return operators;
	}

	@Override
	public State startState() {
		return new QueenState(size);
	}

	public QueenProblem(int size) {
		super();
		this.size = size;
		this.operators = new HashSet<Operator>();
		for (int i = 1; i <= size; i++) {
			this.operators.add(new QueenOperator(size, i));
		}

	}

}
