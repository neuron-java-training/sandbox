package hu.neuron.queen.kiralyneni;

import hu.neuron.queen.tools.Operator;
import hu.neuron.queen.tools.Problem;
import hu.neuron.queen.tools.State;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class QueenProblem implements Problem
{

	static Set<Operator> operators = new HashSet<Operator>();
	static
	{
		operators.add(new QueenOperator(1));
		operators.add(new QueenOperator(2));
		operators.add(new QueenOperator(3));
		operators.add(new QueenOperator(4));
		operators.add(new QueenOperator(5));
		operators.add(new QueenOperator(6));
		operators.add(new QueenOperator(7));
		operators.add(new QueenOperator(8));
	}

	@Override
	public Collection<Operator> operators()
	{
		return operators;
	}

	@Override
	public State startState()
	{
		return new QueenState();
	}

}
