package algorithms;

import java.util.Collection;
import java.util.LinkedList;

import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.State;

public class NodeBackTrack extends Nodes {

	protected LinkedList<Operator> unused;

	public LinkedList<Operator> getUnused() {
		return unused;
	}

	public void setUnused(LinkedList<Operator> unused) {
		this.unused = unused;
	}

	public NodeBackTrack(State state, Operator op, Collection<Operator> ops) {
		super(state, op);
		unused = new LinkedList<Operator>();
		for (Operator o : ops) {
			if (o.isApplicable(state)) {
				unused.add(o);
			}
		}

	}
}
