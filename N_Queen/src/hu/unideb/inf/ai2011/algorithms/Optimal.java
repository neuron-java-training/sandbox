package hu.unideb.inf.ai2011.algorithms;

import hu.unideb.inf.ai2011.CostOperator;
import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.State;

import java.util.Collection;
import java.util.LinkedList;


class OptimalNode {
	
	State state;
	
	Operator op;
	
	int depth;
	
	double cost;
	
	OptimalNode parent;
	
	LinkedList<Operator> operators;
	
	OptimalNode( State state, OptimalNode parent, Operator op, Collection<Operator> ops) {
		this.state = state;
		this.op = op;
		this.parent = parent;
		this.depth = parent == null ? 1 : parent.depth + 1;
		this.cost = (parent == null ? 0 : parent.cost) + ( op instanceof CostOperator ?
			      ((CostOperator)op).cost(parent.state) : 1 );
		operators = new LinkedList<Operator>();
		for ( Operator o : ops )
			if ( o.isApplicable(state) )
				operators.add(o);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof OptimalNode)) {
			return false;
		}
		OptimalNode other = (OptimalNode) obj;
		if (cost != other.cost) {
			return false;
		}
//		if (depth != other.depth) {
//			return false;
//		}
		if (!state.equals(other.state)) {
			return false;
		}
		return true;
	}
	
}

public class Optimal {
	
	public static final boolean PRINT_PATH = true;
	
	Problem p;
	
	public Optimal( Problem p ) {
		this.p = p;
	}
	
	LinkedList<OptimalNode> opened = null;
	LinkedList<OptimalNode> closed = null;
	OptimalNode solution = null;
	
	public State getGoal() {
		return solution != null ? solution.state : null;
	}
	
	public boolean run() {
		opened = new LinkedList<OptimalNode>();
		closed = new LinkedList<OptimalNode>();
		opened.add(new OptimalNode(p.startState(), null, null, p.operators()));
		while ( true ) {
			//System.out.println(("opened: " + opened.size() + ", closed: " + closed.size()));
			if ( opened.isEmpty() )
				return false;
			OptimalNode actNode = opened.getFirst();
			for (int i = 1; i < opened.size(); i++) {
				if (opened.get(i).cost <= actNode.cost) {
					actNode = opened.get(i);
				}
			}
			//System.out.println(actNode);
			if (actNode.state.isGoal() ) {
				solution = actNode;
//				printSolution(solution);
				return true;	
			}
//			closed.add(opened.removeFirst());
			expand(actNode);
		}
	}
	
	public void expand(OptimalNode node) {
		for (Operator o : node.operators) {
			OptimalNode newNode = new OptimalNode(o.apply(node.state), node, o, p.operators());
			if (!opened.contains(newNode) && !closed.contains(newNode)) {
				opened.addLast(newNode);
			}
			else if (opened.contains(newNode)) {
				OptimalNode on = opened.get(opened.indexOf(newNode));
				if (newNode.cost < on.cost) {
					on.parent = node;
					on.op = o;
					on.cost = on.cost;
				}
			}
		}
		opened.remove(node);
		closed.add(node);
	}
	
	public void printSolution(OptimalNode node) {
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
