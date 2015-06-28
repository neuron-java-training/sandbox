package hu.unideb.inf.ai2011.algorithms;

import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.State;

import java.util.Collection;
import java.util.LinkedList;


class DepthFirstNode {
	
	State state;
	
	Operator op;
	
	int depth;
	
	DepthFirstNode parent;
	
	LinkedList<Operator> operators;
	
	DepthFirstNode( State state, DepthFirstNode parent, Operator op, Collection<Operator> ops) {
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
		if (!(obj instanceof DepthFirstNode)) {
			return false;
		}
		DepthFirstNode other = (DepthFirstNode) obj;
		if (!state.equals(other.state)) {
			return false;
		}
		return true;
	}
	
}

public class DepthFirst {
	
	public static final boolean ALL_SOLUTIONS = true;
	
	public static final boolean PRINT_PATH = true;
	
	Problem p;
	
	public DepthFirst( Problem p ) {
		this.p = p;
	}
	
	LinkedList<DepthFirstNode> opened = null;
	LinkedList<DepthFirstNode> closed = null;
	DepthFirstNode solution = null;
	
	public State getGoal() {
		return solution != null ? solution.state : null;
	}
	
	public boolean run() {
		opened = new LinkedList<DepthFirstNode>();
		closed = new LinkedList<DepthFirstNode>();
		opened.add(new DepthFirstNode(p.startState(), null, null, p.operators()));
		while ( true ) {
//			System.out.println(("opened: " + opened.size() + ", closed: " + closed.size()));
			if ( opened.isEmpty() )
				return false;
			DepthFirstNode actNode = opened.getFirst();
			if (actNode.state.isGoal() ) {
				solution = actNode;
//				printSolution(solution);
				if ( ALL_SOLUTIONS )
		        {
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
	
	public void expand(DepthFirstNode node) {
		for (Operator o : node.operators) {
			DepthFirstNode newNode = new DepthFirstNode(o.apply(node.state), node, o, p.operators());
			if (!(opened.contains(newNode) || closed.contains(newNode))) {
				opened.addFirst(newNode);
			}
		}
	}
	
	public void printSolution(DepthFirstNode node) {
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
