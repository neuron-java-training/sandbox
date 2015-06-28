package algorithms;

import java.util.LinkedList;
import java.util.List;

import run.Result;
import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.State;


public class BreadthFirstSearch implements Search {

	Problem p;
	Result res = new Result();
	
	public BreadthFirstSearch( Problem p ) {
		res.setStart(System.currentTimeMillis());
		this.p = p;
	}
	
	
	
	private LinkedList<NodeBreadthFirstSearch> openNodes;
	
	private LinkedList<NodeBreadthFirstSearch> closedNodes;
	
	private NodeBreadthFirstSearch result;
	
	@Override
	public boolean run() {
		closedNodes = new LinkedList<NodeBreadthFirstSearch>();
		openNodes = new LinkedList<NodeBreadthFirstSearch>();
		openNodes.add( new NodeBreadthFirstSearch( p.startState(), null, null) );
		
		while ( true ) {
			if ( openNodes.isEmpty() ) {
				result = null;
				return false;
			}
			NodeBreadthFirstSearch node = openNodes.removeFirst();
			if ( node.state.isGoal() ) {
				result = node;
				res.setStop(System.currentTimeMillis());
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
					openNodes.addLast( new NodeBreadthFirstSearch(newState, op, node) );
				}
			}
			res.setDb(res.getDb() + 1);
		}
		
	}
	
	private NodeBreadthFirstSearch search(List<NodeBreadthFirstSearch> nodeList, State state) {
		for ( NodeBreadthFirstSearch node : nodeList )
			if ( state.equals(node.state) )
				return node;
		return null;
	}

	@Override
	public State getGoal() {
		return result == null ? null : result.state;
	}
	
	public List<Operator> getSolution() {
		if ( result == null )
			return null;
		LinkedList<Operator> solution = new LinkedList<Operator>();
		NodeBreadthFirstSearch tmp = result;
		while ( tmp.op != null ) {
			solution.addFirst(tmp.op);
			tmp = tmp.parent;
		}
		return solution;
	}
	
	@Override
	public String res() {
		return String.valueOf(res.getStop()-res.getStart() + "\n" + res.getDb());
	}
	
}
