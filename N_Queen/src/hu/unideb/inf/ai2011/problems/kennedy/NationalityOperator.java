package hu.unideb.inf.ai2011.problems.kennedy;

//import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.State;

public class NationalityOperator extends KennedyOperator {

	private final int n;
	
	private final Nationality nation;

	public NationalityOperator(int n, Nationality nation) {
		this.n = n;
		this.nation = nation;
	}

	@Override
	protected int getColumn() {
		return n;
	}

	@Override
	protected int getRow() {
		return 2;
	}

	@Override
	protected Object getValue() {
		return nation;
	}

	@Override
	public boolean isApplicable(State s) {
		KennedyState state = (KennedyState)s;
		Object[][] h = state.h;
		
		if ( h[1][5] == null )
			return false;

		if ( h[2][n] != null )
			return false;

		for (int i = 1; i <= 5; i++)
			if ( i < n && ( h[2][i] == null || h[2][i] == nation ) )
				return false;

		if ( nation == Nationality.ENGLISH && h[1][n] != Color.RED )
			return false;

		if ( h[1][n] == Color.RED && nation != Nationality.ENGLISH )
			return false;

		if ( nation == Nationality.NORWEGIAN && n != 1 )
			return false;
			
		if ( n == 1 && nation != Nationality.NORWEGIAN )
			return false;

		if ( nation == Nationality.NORWEGIAN ) {
			boolean exists = false;
			for (int i = 1; i <= 5; i++)
				if ( ( i + 1 == n || i - 1 == n ) && h[1][i] == Color.BLUE )
					exists = true;
			if ( ! exists )
				return false;
		}
		
		return true;
	}
	
}
