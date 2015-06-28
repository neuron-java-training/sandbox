package hu.unideb.inf.ai2011.algorithms;

import hu.unideb.inf.ai2011.HeuristicState;
import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.State;

import java.util.ArrayList;
import java.util.List;

public class HillClimbing {
	private Problem p;
	
	public HillClimbing( Problem p ) {
		this.p = p;
	}
	
	private State current = null;
	
	public boolean run() {
		current = p.startState();
		while ( true ) {
			if ( current.isGoal() ) {
				printSolution();
				return true;
			}
			List<Operator> ops = new ArrayList<Operator>();
			for ( Operator o : p.operators() )
				if ( o.isApplicable(current) )
					ops.add(o);
			if ( ! ops.isEmpty() ) {
				Operator o = ops.get(0);
				for (int i = 1; i < ops.size(); i++) {
					if (current instanceof HeuristicState && ((HeuristicState)(ops.get(i).apply(current))).heuristic() <= ((HeuristicState)(o.apply(current))).heuristic()) {
//					if (ops.get(i).apply(current).heuristic() <= o.apply(current).heuristic()) {
						o = ops.get(i);
					}
				}
				
//				System.out.println(current);
//				System.out.println(o);
				current = o.apply(current);
			} else {
				return false;
			}	
		}
	}

	public State getGoal() {
		return current.isGoal() ? current : null;
	}
	

	public void printSolution() {
		System.out.println("A solution:\n" + getGoal());
	}
}
