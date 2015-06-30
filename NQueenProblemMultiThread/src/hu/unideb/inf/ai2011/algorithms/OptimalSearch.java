package hu.unideb.inf.ai2011.algorithms;

import hu.unideb.inf.ai2011.Cost;
import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.State;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class OptimalSearch {

	private final Problem p;
	
	private final Cost cost;

	public OptimalSearch(Problem p, Cost cost ) {
		this.cost = cost;
		this.p = p;
	}
	
	
	private static class Node implements Comparable<Node> {
		
		final State state;
		
		Operator op;
		
		Node parent;
		
		double g;

		Node(State state, Operator op, Node parent, Cost cost ) {
			this.g = parent == null ? 0 : ( parent.g + cost.getCost(parent.state, op) );
			this.op = op;
			this.parent = parent;
			this.state = state;
		}
		
		void update( Operator op, Node parent, Cost cost ) {
			this.g = parent == null ? 0 : ( parent.g + cost.getCost(parent.state, op) );
			this.op = op;
			this.parent = parent;
		}
		
		public int compareTo( Node node ) {
			if ( node.g > g )
				return -1;
			else if ( node.g < g )
				return +1;
			else
				return 0;
		}
		
	}
	
	
	private LinkedList<Node> openNodes;
	
	private LinkedList<Node> closedNodes;
	
	private Node result;
	
	public boolean run() {
		closedNodes = new LinkedList<Node>();
		openNodes = new LinkedList<Node>();
		openNodes.add( new Node( p.startState(), null, null, cost ) );
		
		while ( true ) {
			if ( openNodes.isEmpty() ) {
				result = null;
				return false;
			}
			
			Collections.sort(openNodes);
			Node actNode = openNodes.removeFirst();
			if ( actNode.state.isGoal() ) {
				result = actNode;
				return true;
			}
			
			closedNodes.add(actNode);
			for ( Operator op : p.operators() ) {
				if ( op.isApplicable(actNode.state) ) {
					State newState = op.apply(actNode.state);
					Node newNode = new Node(newState, op, actNode, cost );
					Node similar;
					if ( ( similar = search( openNodes, newState ) ) != null ) {
						if ( similar.g > newNode.g ) {
							// Nyilt csucs frissitese
							similar.update(newNode.op, newNode.parent, cost);
						}
					} else if ( ( similar = search( closedNodes, newState ) ) != null ) {
					} else {
						openNodes.add( newNode );
					}
				}
			}
			
		}
		
	}
	
	private Node search(List<Node> nodeList, State state) {
		for ( Node node : nodeList )
			if ( state.equals(node.state) )
				return node;
		return null;
	}

	public State getGoal() {
		return result == null ? null : result.state;
	}
	
	public List<Operator> getSolution() {
		if ( result == null )
			return null;
		LinkedList<Operator> solution = new LinkedList<Operator>();
		Node tmp = result;
		while ( tmp.op != null ) {
			solution.addFirst(tmp.op);
			tmp = tmp.parent;
		}
		return solution;
	}

}
