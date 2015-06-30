package hu.unideb.inf.ai2011.algorithms;

import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TrialAndError {

	private Problem p;
	
	public TrialAndError( Problem p ) {
		this.p = p;
	}
	
	private State current = null;
	
	public boolean run() {
		Random r = new Random();
		current = p.startState();
		while ( true ) {
			if ( current.isGoal() ) {
				return true;
			}
			List<Operator> ops = new ArrayList<Operator>();
			for ( Operator o : p.operators() )
				if ( o.isApplicable(current) )
					ops.add(o);
			if ( ! ops.isEmpty() ) {
				Operator o = ops.get(r.nextInt(ops.size()));
				//System.out.println(current);
				//System.out.println(o);
				current = o.apply(current);
			} else {
				return false;
			}	
		}
	}

	public State getGoal() {
		return current.isGoal() ? current : null;
	}
}
