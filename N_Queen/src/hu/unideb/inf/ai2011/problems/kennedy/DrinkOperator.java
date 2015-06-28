package hu.unideb.inf.ai2011.problems.kennedy;

//import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.State;

public class DrinkOperator extends KennedyOperator {

	protected int n;
	
	protected Drink drink;
	
	public DrinkOperator(int n, Drink drink) {
		this.drink = drink;
		this.n = n;
	}

	@Override
	public boolean isApplicable(State s) {
		KennedyState state = (KennedyState)s;
		Object[][] h = state.h;
		
		if ( h[3][5] == null )
			return false;
		
		if ( h[4][n] != null )
			return false;

		for (int i = 1; i <= 5; i++)
			if ( i < n && ( h[4][i] == null || h[4][i] == drink ) )
				return false;

		// 3.
		if ( drink == Drink.COFFEE && h[1][n] != Color.GREEN )
			return false;
		
		// 3.
		if ( h[1][n] == Color.GREEN && drink != Drink.COFFEE )
			return false;

		// 4. 
		if ( drink == Drink.TEA && h[2][n] != Nationality.UKRAINIAN )
			return false;
		
		// 4. 
		if ( h[2][n] == Nationality.UKRAINIAN && drink != Drink.TEA )
			return false;
		
		// 8. 
		if ( drink == Drink.MILK && n != 3 )
			return false;
		
		// 8. 
		if ( n == 3 && drink != Drink.MILK )
			return false;
		
		// 12. 
		if ( drink == Drink.ORANGE_JUICE && h[3][n] != Cigarette.LUCKY_STRIKE )
			return false;
		
		// 12. 
		if ( h[3][n] == Cigarette.LUCKY_STRIKE && drink != Drink.ORANGE_JUICE )
			return false;
		
		return true;
	}

	@Override
	protected int getColumn() {
		return n;
	}

	@Override
	protected int getRow() {
		return 4;
	}

	@Override
	protected Object getValue() {
		return drink;
	}
	
}
