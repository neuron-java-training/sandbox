package hu.unideb.inf.ai2011.problems.hanoi;

import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.State;

public class HanoiOperator implements Operator {

	private int u, w;
	
	public HanoiOperator(int u, int w) {
		this.u = u;
		this.w = w;
	}

	private int d( int n, HanoiState state ) {
		for ( int i = 1; i <= 3; i++ )
			if ( state.a[i] == n )
				return i;
		return 4;
	}
	
	@Override
	public boolean isApplicable(State s) {
		HanoiState state = (HanoiState)s;
		return d(u,state) < 4 && d(u,state) < d(w,state);
	}

	@Override
	public State apply(State s) {
		HanoiState oldState = (HanoiState)s;
		HanoiState newState = new HanoiState();
		int moved = d(u,oldState);
		
		for ( int i = 1; i <= 3; i++ )
			newState.a[i] = ( i == moved ) ? w : oldState.a[i];
		return newState;
	}

	@Override
	public String toString() {
		return u + " -> " + w;
	}

}
