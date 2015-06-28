package neuron3ora.feladat8Kiralyno;

import java.util.Collection;
import java.util.LinkedList;


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
			if (actNode.state.isGoal() )
				return true;
			if ( ! actNode.unused.isEmpty() ) {
				Operator op = actNode.unused.removeFirst();
				State newState = op.apply(actNode.state);
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

}
