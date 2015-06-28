package hu.unideb.inf.ai2011.algorithms;

import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.State;

import java.util.Collection;
import java.util.LinkedList;


class BranchAndBoundNode {
	
	State state;
	
	Operator op;
	
	LinkedList<Operator> unused;
	
	BranchAndBoundNode( State state, Operator op, Collection<Operator> ops ) {
		this.state = state;
		this.op = op;
		this.unused = new LinkedList<Operator>();
		for ( Operator o : ops )
			if ( o.isApplicable(state) )
				this.unused.add(o);
	}
	
}

public class BranchAndBound {
	
	Problem p;
	
	int bound;
	
	public BranchAndBound( Problem p, int bound ) {
		this.p = p;
		this.bound = bound;
	}
	
	LinkedList<BranchAndBoundNode> actPath = null;
	
	LinkedList<BranchAndBoundNode> solutions = new LinkedList<BranchAndBoundNode>();
	
	public State getGoal() {
		//return actPath != null && ! actPath.isEmpty() ? actPath.getLast().state : null;
		return solutions != null && ! solutions.isEmpty() ? solutions.getLast().state : null;
	}
	
	public boolean run() {
		boolean solutionFound = false;
		
		actPath = new LinkedList<BranchAndBoundNode>();
		actPath.add( new BranchAndBoundNode(p.startState(), null, p.operators()) );
		while ( true ) {
			if ( actPath.isEmpty() )
				break;
			BranchAndBoundNode actNode = actPath.getLast();
			if (actNode.state.isGoal() ) {
				solutionFound = true;
//				printSolution();
				solutions.add(actNode);
				bound = actPath.size();
//				System.out.println("New Bound: " + bound);
			}
			// úthosszkorlát
			if (actPath.size() == bound) {
				actPath.removeLast();
				continue;
			}
			if ( ! actNode.unused.isEmpty() ) {
				Operator op = actNode.unused.removeFirst();
				State newState = op.apply(actNode.state);
				// körfigyelés
				boolean found = false;
				for ( BranchAndBoundNode node : actPath )
					if ( node.state.equals(newState) ) {
						found = true;
						break;
					}
				if ( ! found ) {
					actPath.add(new BranchAndBoundNode(newState, op, p.operators()));
				}
			} else {
				actPath.removeLast();
			}
		}
		if (solutionFound) {
			return true;
		}
		else {
			return false;
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
