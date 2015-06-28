package hu.unideb.inf.ai2011.problems.kennedy;

import java.util.Collection;
import java.util.HashSet;

import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.State;

public class KennedyProblem implements Problem {

	private HashSet<Operator> operators;
	
	public KennedyProblem() {
		operators = new HashSet<Operator>(125);
		for ( int i = 1; i <= 5; i++ ) {
			for ( Color c : Color.values() )
				operators.add( new ColorOperator(i,c) );
			for ( Nationality n : Nationality.values() )
				operators.add( new NationalityOperator(i,n) );
			for ( Cigarette c : Cigarette.values() )
				operators.add( new CigaretteOperator(i,c) );
			for ( Drink d : Drink.values() )
				operators.add( new DrinkOperator(i,d) );
			for ( Pet p : Pet.values() )
				operators.add( new PetOperator(i,p) );
		}
	}
	
	@Override
	public Collection<Operator> operators() {
		return operators;
	}

	@Override
	public State startState() {
		return new KennedyState();
	}
	
	

}
