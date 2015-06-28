package algorithms;

import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.State;

public class NodeBreadthFirstSearch extends Nodes {
	
	NodeBreadthFirstSearch parent;
	
	int deep;


	public NodeBreadthFirstSearch(State state, Operator op, NodeBreadthFirstSearch parent ) {
		super(state, op);
		this.deep = parent == null ? 0 : parent.deep+1;
		this.parent = parent;
		
	}

}
