package hu.unideb.inf.ai2011.algorithms;

import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.State;

import java.util.LinkedList;
import java.util.List;


public class BreadthFirstSearch {

	private Problem p;
	
	public BreadthFirstSearch( Problem p ) {
		this.p = p;
	}
	
	private static class Node {
		
		State state;
		
		Operator op;
		
		Node parent;
		
		int deep;

		public Node(State state, Operator op, Node parent ) {
			this.deep = parent == null ? 0 : parent.deep+1;
			this.op = op;
			this.parent = parent;
			this.state = state;
		}
		
	}
	
	private LinkedList<Node> openNodes;
	
	private LinkedList<Node> closedNodes;
	
	private Node result;
	
	public boolean run() {
		closedNodes = new LinkedList<Node>();
		openNodes = new LinkedList<Node>();
		openNodes.add( new Node( p.startState(), null, null) );
		
		while ( true ) {
			if ( openNodes.isEmpty() ) {
				result = null;
				return false;
			}
			Node node = openNodes.removeFirst();
			if ( node.state.isGoal() ) {
				result = node;
				return true;
			}
			// kiterjesztés
			closedNodes.add(node);
			for ( Operator op : p.operators() ) {
				if ( op.isApplicable(node.state) ) {
					State newState = op.apply(node.state);
					if ( search( openNodes, newState ) != null )
						continue;
					if ( search( closedNodes, newState ) != null )
						continue;
					openNodes.addLast( new Node(newState, op, node) );
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
