package hu.unideb.inf.ai2011.algorithms;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import hu.unideb.inf.ai2011.Cost;
import hu.unideb.inf.ai2011.Heuristic;
import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.State;

public class ABasic {

	private final Problem p;
	
	private final Heuristic heur;
	
	private final Cost cost;

	public ABasic(Problem p, Cost cost, Heuristic heur ) {
		this.cost = cost;
		this.heur = heur;
		this.p = p;
	}
	
	
	private static class Node implements Comparable<Node> {
		
		final State state;
		
		Operator op;
		
		Node parent;
		
		final double h;
		
		double g;

		Node(State state, Operator op, Node parent, Cost cost, Heuristic heur ) {
			this.g = parent == null ? 0 : ( parent.g + cost.getCost(parent.state, op) );
			this.h = heur.getHeuristic(state);
			this.op = op;
			this.parent = parent;
			this.state = state;
		}
		
		void update( Operator op, Node parent, Cost cost ) {
			this.g = parent == null ? 0 : ( parent.g + cost.getCost(parent.state, op) );
			this.op = op;
			this.parent = parent;
		}
		
		double getFullCost() {
			return h + g;
		}
		
		public int compareTo( Node node ) {
			if ( node.getFullCost() > getFullCost() )
				return -1;
			else if ( node.getFullCost() < getFullCost() )
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
		openNodes.add( new Node( p.startState(), null, null, cost, heur ) );
		
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
					Node newNode = new Node(newState, op, actNode, cost, heur);
					Node similar;
					if ( ( similar = search( openNodes, newState ) ) != null ) {
						if ( similar.getFullCost() > newNode.getFullCost() ) {
							// Nyilt csucs frissitese
							similar.update(newNode.op, newNode.parent, cost);
						}
					} else if ( ( similar = search( closedNodes, newState ) ) != null ) {
						if ( similar.getFullCost() > newNode.getFullCost() ) {
							// Zart csucs problema
							closedNodes.remove(similar);
							similar.update(newNode.op, newNode.parent, cost);
							openNodes.add(similar);
						}
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
