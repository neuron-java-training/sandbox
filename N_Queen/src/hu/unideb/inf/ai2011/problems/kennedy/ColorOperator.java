package hu.unideb.inf.ai2011.problems.kennedy;

//import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.State;

public class ColorOperator extends KennedyOperator {

	private int n;
	
	private Color color;

	public ColorOperator( int n, Color color) {
		this.color = color;
		this.n = n;
	}


	@Override
	public boolean isApplicable(State s) {
		KennedyState state = (KennedyState)s;
		Object[][] h = state.h;
		
		for (int i = 1; i <= 5; i++)
			if ( i < n && ( h[1][i] == null || h[1][i] == color ) )
				return false;
				
		if ( h[1][n] != null )
			return false;
			
		if ( color == Color.GREEN ) {
			boolean exists = false;
			for ( int j = 1; j <= 5; j++ )
				if ( j == n-1 && h[1][j] == Color.IVORY )
					exists = true;
			if ( ! exists )
				return false;
		}
		
		return true;
	} 
	

	@Override
	protected int getColumn() {
		return n;
	}

	@Override
	protected int getRow() {
		return 1;
	}

	@Override
	protected Object getValue() {
		return color;
	}

}
