package hu.unideb.inf.ai2011.algorithms;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.State;

public class BackTrack {

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
	
	public BackTrack( Problem p ) {
		this.p = p;
	}
	
	private LinkedList<Node> actPath = null;
	
	public State getGoal() {
		return actPath != null && ! actPath.isEmpty() ? actPath.getLast().state : null;
	}
	
	public boolean run() {
		actPath = new LinkedList<Node>();
		actPath.add( new Node(p.startState(), null, p.operators()) );
		while ( true ) {
			if ( actPath.isEmpty() )
				return false;
			Node actNode = actPath.getLast();
			System.out.println(actNode.state);
			if (actNode.state.isGoal() )
				return true;
			if ( ! actNode.unused.isEmpty() ) {
				Operator op = actNode.unused.removeFirst();
				State newState = op.apply(actNode.state);
				System.out.println(op);
				boolean found = false;
				for ( Node node : actPath )
					if ( node.state.equals(newState) ) {
						System.out.println("kört találtunk");
						found = true;
						break;
					}
					if ( ! found ) {
						actPath.add(new Node(newState, op, p.operators() ));
					}
			} else {
				System.out.println("visszalépés");
				actPath.removeLast();
			}
		}
	}

	public List<Operator> getSolution() {
		if ( actPath == null || actPath.isEmpty() )
			return null;
		LinkedList<Operator> solution = new LinkedList<Operator>();
		for ( int i = 1; i < actPath.size(); i++ )
			solution.add( actPath.get(i).op );
		return solution;
	}

}
