package hu.unideb.inf.ai2011.algorithms;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.State;

public class BackTrack2 {

	private class Node {
		
		State state;
		
		Operator op;
		
		LinkedList<Operator> unused;
		
		Node( State state, Operator op, Collection<Operator> ops ) {
			this.state = state;
			this.op = op;
			unused = new LinkedList<Operator>();
			for ( Operator o : ops )
				if ( o.isApplicable(state) )
					unused.add(o);
		}
		
	}
	
	private Problem p;
	
	private int limit;
	
	public BackTrack2( Problem p, int limit ) {
		this.p = p;
		this.limit = limit;
	}
	
	private LinkedList<Node> actPath = null;
	
	private LinkedList<Node> bestPath = null;
	
	public State getGoal() {
		return bestPath != null ? bestPath.getLast().state : null;
	}
	
	public boolean run() {
		actPath = new LinkedList<Node>();
		actPath.add( new Node(p.startState(), null, p.operators()) );
		while ( true ) {
			if ( actPath.isEmpty() )
				return bestPath != null;
			Node actNode = actPath.getLast();
			if (actNode.state.isGoal() ) {
				bestPath = new LinkedList<Node>(actPath);
				limit = bestPath.size() - 1;
			}
			if ( ! actNode.unused.isEmpty() && actPath.size() < limit ) {
				Operator op = actNode.unused.removeFirst();
				State newState = op.apply(actNode.state);
				actPath.add(new Node(newState, op, p.operators() ));
			} else {
				actPath.removeLast();
			}
		}
	}

	public List<Operator> getSolution() {
		if ( bestPath == null || bestPath.isEmpty() )
			return null;
		LinkedList<Operator> solution = new LinkedList<Operator>();
		for ( int i = 1; i < bestPath.size(); i++ )
			solution.add( bestPath.get(i).op );
		return solution;
	}

}
