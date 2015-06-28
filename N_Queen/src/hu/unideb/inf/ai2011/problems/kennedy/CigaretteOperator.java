package hu.unideb.inf.ai2011.problems.kennedy;

//import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.State;

public class CigaretteOperator extends KennedyOperator {
	
	private Cigarette cigarette;
	
	private int n;
	
	public CigaretteOperator(int n, Cigarette cigarette) {
		this.cigarette = cigarette;
		this.n = n;
	}

	@Override
	public boolean isApplicable(State s) {
		KennedyState state = (KennedyState)s;
		Object[][] h = state.h;
		
		if ( h[2][5] == null )
			return false;
		
		if ( h[3][n] != null )
			return false;
		
		for (int i = 1; i <= 5; i++)
			if ( i < n && ( h[3][i] == null || h[3][i] == cigarette ) )
				return false;

		if ( cigarette == Cigarette.KOOLS && h[1][n] != Color.YELLOW )
			return false;
		
		if ( h[1][n] == Color.YELLOW && cigarette != Cigarette.KOOLS )
			return false;
		
		if ( cigarette == Cigarette.PARLIAMENT && h[2][n] != Nationality.JAPANESE )
			return false;
		
		if ( h[2][n] == Nationality.JAPANESE && cigarette != Cigarette.PARLIAMENT )
			return false;
		
		return true;
	}

	@Override
	protected int getColumn() {
		return n;
	}

	@Override
	protected int getRow() {
		return 3;
	}

	@Override
	protected Object getValue() {
		return cigarette;
	}

}
