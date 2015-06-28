package hu.unideb.inf.ai2011.algorithms;

import hu.unideb.inf.ai2011.HeuristicState;
import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.State;

import java.util.Collection;
import java.util.LinkedList;

class BestFirstNode {
	
	State state;
	
	Operator op;
	
	int depth;
	
	double heuristic;
	
	BestFirstNode parent;
	
	LinkedList<Operator> operators;
	
	BestFirstNode( State state, BestFirstNode parent, Operator op, Collection<Operator> ops) {
		this.state = state;
		this.op = op;
		this.parent = parent;
		this.depth = parent == null ? 1 : parent.depth + 1;
		this.heuristic = (state instanceof HeuristicState ? ((HeuristicState)state).heuristic() : 1);
		operators = new LinkedList<Operator>();
		for ( Operator o : ops )
			if ( o.isApplicable(state) )
				operators.add(o);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof BestFirstNode)) {
			return false;
		}
		BestFirstNode other = (BestFirstNode) obj;
		if (state == null) {
			if (other.state != null) {
				return false;
			}
		} else if (!state.equals(other.state)) {
			return false;
		}
		return true;
	}
	
}

public class BestFirst {
	
	public static final boolean PRINT_PATH = true;
	
	Problem p;
	
	public BestFirst( Problem p ) {
		this.p = p;
	}
	
	LinkedList<BestFirstNode> opened = null;
	LinkedList<BestFirstNode> closed = null;
	BestFirstNode solution = null;
	
	public State getGoal() {
		return solution != null ? solution.state : null;
	}
	
	public boolean run() {
		opened = new LinkedList<BestFirstNode>();
		closed = new LinkedList<BestFirstNode>();
		opened.add(new BestFirstNode(p.startState(), null, null, p.operators()));
		while ( true ) {
//			System.out.println(("opened: " + opened.size() + ", closed: " + closed.size()));
			if ( opened.isEmpty() )
				return false;
			BestFirstNode actNode = opened.getFirst();
			for (int i = 1; i < opened.size(); i++) {
				if (opened.get(i).heuristic <= actNode.heuristic) {
					actNode = opened.get(i);
				}
			}
			if (actNode.state.isGoal() ) {
				solution = actNode;
//				printSolution(solution);
				return true;	
			}
//			closed.add(opened.removeFirst());
			expand(actNode);
		}
	}
	
	public void expand(BestFirstNode node) {
		for (Operator o : node.operators) {
			BestFirstNode newNode = new BestFirstNode(o.apply(node.state), node, o, p.operators());
			if (!(opened.contains(newNode) || closed.contains(newNode))) {
				opened.addLast(newNode);
			}
		}
		opened.remove(node);
		closed.add(node);
	}
	
	public void printSolution(BestFirstNode node) {
		if ( !PRINT_PATH ) {
			System.out.println( node );
		}
		else if ( node != null )
		{
			printSolution( node.parent );
			System.out.println( (node.op != null ? node.op + "\n" : "") + node.state );
//			System.out.print(node.op != null ? node.op : "");
		}
	}
}
