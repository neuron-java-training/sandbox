package hu.unideb.inf.ai2011.algorithms;

import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.State;

import java.util.Collection;
import java.util.LinkedList;


class BreadthFirstNode {
	
	State state;
	
	Operator op;
	
	int depth;
	
	BreadthFirstNode parent;
	
	LinkedList<Operator> operators;
	
	BreadthFirstNode( State state, BreadthFirstNode parent, Operator op, Collection<Operator> ops) {
		this.state = state;
		this.op = op;
		this.parent = parent;
		this.depth = parent == null ? 1 : parent.depth + 1;
		operators = new LinkedList<Operator>();
		for ( Operator o : ops )
			if ( o.isApplicable(state) )
				operators.add(o);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof BreadthFirstNode)) {
			return false;
		}
		BreadthFirstNode other = (BreadthFirstNode) obj;
		if (!state.equals(other.state)) {
			return false;
		}
		return true;
	}
	
}

public class BreadthFirst {
	
	public static final boolean ALL_SOLUTIONS = true;
	
	public static final boolean PRINT_PATH = true;
	
	Problem p;
	
	public BreadthFirst( Problem p ) {
		this.p = p;
	}
	
	LinkedList<BreadthFirstNode> opened = null;
	LinkedList<BreadthFirstNode> closed = null;
	BreadthFirstNode solution = null;
	
	public State getGoal() {
		return solution != null ? solution.state : null;
	}
	
	public boolean run() {
		opened = new LinkedList<BreadthFirstNode>();
		closed = new LinkedList<BreadthFirstNode>();
		opened.add(new BreadthFirstNode(p.startState(), null, null, p.operators()));
		while ( true ) {
//			System.out.println(("opened: " + opened.size() + ", closed: " + closed.size()));
			
			if ( opened.isEmpty() )
				return false;
			BreadthFirstNode actNode = opened.getFirst();
			if (actNode.state.isGoal() ) {
				solution = actNode;
//				printSolution(solution);
				if ( ALL_SOLUTIONS )
		        {
//		          printSolution(solution);
		          closed.add( opened.removeFirst() );
		          continue;
		        }
				else {
					return true;	
				}
			}
			closed.add(opened.removeFirst());
			expand(actNode);
		}
	}
	
	public void expand(BreadthFirstNode node) {
		for (Operator o : node.operators) {
			BreadthFirstNode newNode = new BreadthFirstNode(o.apply(node.state), node, o, p.operators());
			if (!(opened.contains(newNode) || closed.contains(newNode))) {
				opened.addLast(newNode);
			}
		}
	}
	
	public void printSolution(BreadthFirstNode node) {
		if ( !PRINT_PATH ) {
			System.out.println( node );
		}
		else if ( node != null )
		{
			printSolution( node.parent );
			System.out.println( (node.op != null ? node.op + "\n" : "") + node.state );
		}
	}
}
