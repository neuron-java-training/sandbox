package hu.unideb.inf.ai2011.problems.kennedy;

import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.State;

public abstract class KennedyOperator implements Operator {

	protected abstract int getRow();
	
	protected abstract int getColumn();
	
	protected abstract Object getValue();
	
	@Override
	public final State apply(State s) {
		KennedyState oldState = (KennedyState)s; 
		KennedyState newState = new KennedyState();
		int u = getRow();
		int w = getColumn();
		for ( int i = 1; i <= 5; i++ )
			for ( int j = 1; j <= 5; j++ )
				newState.h[i][j] =
					i == u && j == w ? getValue() : oldState.h[i][j];
		return newState;
	}

	@Override
	public abstract boolean isApplicable(State s); 

}
