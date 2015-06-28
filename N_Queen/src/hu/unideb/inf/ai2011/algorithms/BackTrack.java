package hu.unideb.inf.ai2011.algorithms;

import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.State;

import java.util.Collection;
import java.util.LinkedList;


class Node {
	
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

public class BackTrack {
	
	Problem p;
	
	public BackTrack( Problem p ) {
		this.p = p;
	}
	
	LinkedList<Node> actPath = null;
	
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
			if (actNode.state.isGoal() ) {
//				printSolution();
				return true;
			}
			if ( ! actNode.unused.isEmpty() ) {
				Operator op = actNode.unused.removeFirst();
				State newState = op.apply(actNode.state);
				// körfigyeléses 
				boolean found = false;
				for ( Node node : actPath )
					if ( node.state.equals(newState) ) {
						found = true;
						break;
					}
				if ( ! found ) {
					actPath.add(new Node(newState, op, p.operators() ));
				}
			} else {
				actPath.removeLast();
			}
		}
	}

	public void printSolution() {
		System.out.println("A solution:");
		for (int i = 0; i < actPath.size(); i++) {
			if (actPath.get(i).op != null) {
				System.out.println(actPath.get(i).op);	
			}
			System.out.println(actPath.get(i).state);
		}
	}
}
