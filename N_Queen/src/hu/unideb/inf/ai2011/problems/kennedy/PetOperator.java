package hu.unideb.inf.ai2011.problems.kennedy;

//import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.State;

public class PetOperator extends KennedyOperator {

	private int n;
	
	private Pet pet;
	
	public PetOperator(int n, Pet pet) {
		this.n = n;
		this.pet = pet;
	}

	@Override
	public boolean isApplicable(State s) {
		KennedyState state = (KennedyState)s;
		Object[][] h = state.h;
		
		if ( h[4][5] == null )
			return false;
		
		if ( h[5][n] != null )
			return false;
		
		for (int i = 1; i <= 5; i++)
			if ( i < n && ( h[5][i] == null || h[5][i] == pet ) )
				return false;

		// 2.
		if ( pet == Pet.DOG && h[2][n] != Nationality.SPANIARD )
			return false;
		
		// 2.
		if ( h[2][n] == Nationality.SPANIARD && pet != Pet.DOG )
			return false;

		// 6.
		if ( pet == Pet.SNAIL && h[3][n] != Cigarette.OLD_GOLD )
			return false;
		
		// 6.
		if ( h[3][n] == Cigarette.OLD_GOLD && pet != Pet.SNAIL )
			return false;
		
		// 10.
		if ( pet == Pet.FOX ) {
			boolean exists = false;
			for (int i = 1; i <= 5; i++)
				if ( (i + 1 == n || i - 1 == n) && h[3][i] == Cigarette.CHESTERFIELD )
					exists = true;
			if ( ! exists )
				return false;
		}
		
		// 11.
		if ( pet == Pet.HORSE ) {
			boolean exists = false;
			for (int i = 1; i <= 5; i++)
				if ( (i + 1 == n || i - 1 == n) && h[3][i] == Cigarette.KOOLS )
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
		return 5;
	}

	@Override
	protected Object getValue() {
		return pet;
	}
	

}
