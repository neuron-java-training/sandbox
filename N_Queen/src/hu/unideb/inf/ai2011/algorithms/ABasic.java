package hu.unideb.inf.ai2011.algorithms;

import hu.unideb.inf.ai2011.CostOperator;
import hu.unideb.inf.ai2011.HeuristicState;
import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.State;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class ANode implements Comparable<ANode> {
	
	State state;
	
	Operator op;
	
	int depth;
	
	double heuristic;
	
	double cost;
	
	ANode parent;
	
	LinkedList<Operator> operators;
	
	ANode( State state, ANode parent, Operator op, Collection<Operator> ops) {
		this.state = state;
		this.op = op;
		this.parent = parent;
		this.depth = parent == null ? 1 : parent.depth + 1;
		this.heuristic = (state instanceof HeuristicState ? ((HeuristicState)state).heuristic() : 1);
		this.cost = (parent == null ? 0 : parent.cost) + (op instanceof CostOperator ? ((CostOperator)op).cost(parent.state) : 1);
		operators = new LinkedList<Operator>();
		for ( Operator o : ops )
			if ( o.isApplicable(state) )
				operators.add(o);
	}

	double getFullCost() {
		return heuristic + cost;
	}
	
	@Override	
	public int compareTo( ANode node ) {
		if ( node.getFullCost() > getFullCost() )
			return -1;
		else if ( node.getFullCost() < getFullCost() )
			return +1;
		else
			return 0;
	}
	
	void update( Operator op, ANode parent, double cost ) {
		this.cost = parent.cost + cost;
		this.op = op;
		this.parent = parent;
	}
}

public class ABasic {

	private final Problem p;
	
	public ABasic(Problem p) {
		this.p = p;
	}
	
	LinkedList<ANode> opened;
	LinkedList<ANode> closed;
	ANode result;
	
	public boolean run() {
		closed = new LinkedList<ANode>();
		opened = new LinkedList<ANode>();
		opened.add( new ANode( p.startState(), null, null, p.operators() ) );
		
		while ( true ) {
			if ( opened.isEmpty() ) {
				result = null;
				return false;
			}
			
			Collections.sort(opened);
			ANode actNode = opened.removeFirst();
			if ( actNode.state.isGoal() ) {
				result = actNode;
//				printSolution(actNode);
				return true;
			}
//			printSolution(actNode);
			closed.add(actNode);
			expand(actNode);	
		}
	}
	
	public void expand(ANode node) {
		for (Operator op : node.operators) {
			State newState = op.apply(node.state);
			ANode newNode = new ANode(newState, node, op, p.operators());
			ANode similar;
			if ( ( similar = search( opened, newState ) ) != null ) {
				if ( similar.getFullCost() > newNode.getFullCost() ) {
					// Nyilt csucs frissitese
					similar.update(newNode.op, newNode.parent, newNode.cost);
				}
			} else if ( ( similar = search( closed, newState ) ) != null ) {
				if ( similar.getFullCost() > newNode.getFullCost() ) {
					// Zart csucs problema
					closed.remove(similar);
					similar.update(newNode.op, newNode.parent, newNode.cost);
					opened.add(similar);
				}
			} else {
				opened.add( newNode );
			}
		}	
	}
	
	private ANode search(List<ANode> nodeList, State state) {
		for ( ANode node : nodeList )
			if ( state.equals(node.state) )
				return node;
		return null;
	}

	public State getGoal() {
		return result == null ? null : result.state;
	}
	
//	public List<Operator> getSolution() {
//		if ( result == null )
//			return null;
//		LinkedList<Operator> solution = new LinkedList<Operator>();
//		ANode tmp = result;
//		printSolution(tmp);
//		while ( tmp.op != null ) {
//			solution.addFirst(tmp.op);
//			tmp = tmp.parent;
//		}
//		return solution;
//	}
	
	public void printSolution(ANode node) {
		if ( node != null ){
			printSolution( node.parent );
			System.out.println( (node.op != null ? node.op + "\n" : "") + node.state );
		}
	}

}
