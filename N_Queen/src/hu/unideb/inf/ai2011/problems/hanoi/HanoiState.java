package hu.unideb.inf.ai2011.problems.hanoi;

import hu.unideb.inf.ai2011.State;

public class HanoiState implements State {

	int[] a = new int[4];
	
	public HanoiState() {
		a[1] = 1; 
		a[2] = 1; 
		a[3] = 1; 
	} 
	
	@Override
	public boolean isGoal() {
		return a[1] == 3 && a[2] == 3 && a[3] == 3;
	}
	
	@Override
	public boolean equals( Object o ) {
		HanoiState hs = (HanoiState)o;
		for ( int i = 1; i <= 3; i++ )
			if ( hs.a[i] != a[i] )
				return false;
		return true;
	}

	@Override
	public String toString() {
		return "("+a[1]+","+a[2]+","+a[3]+")";
	}

}
