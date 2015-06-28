package algorithms;

import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.State;

import java.util.LinkedList;

import run.Result;


public class BackTrack  implements Search{



	
	Problem p;
	Result res = new Result();
	
	public BackTrack( Problem p ) {
		res.setStart(System.currentTimeMillis());
		this.p = p;
	}
	
	LinkedList<NodeBackTrack> actPath = null;
	
	@Override
	public State getGoal() {
		return actPath != null && ! actPath.isEmpty() ? actPath.getLast().state : null;
	}
	
	@Override
	public boolean run() {
		actPath = new LinkedList<NodeBackTrack>();
		actPath.add( new NodeBackTrack(p.startState(), null, p.operators()) );
		while ( true ) {
			if ( actPath.isEmpty() )
				return false;
			NodeBackTrack actNode = actPath.getLast();
			if (actNode.state.isGoal() ) {
				res.setStop(System.currentTimeMillis());
				return true;
			}
			if ( ! actNode.unused.isEmpty() ) {
				Operator op = actNode.unused.removeFirst();
				State newState = op.apply(actNode.state);
				boolean found = false;
				for ( NodeBackTrack node : actPath )
					if ( node.state.equals(newState) ) {
						found = true;
						break;
					}
				if ( ! found ) {
					actPath.add(new NodeBackTrack(newState, op, p.operators() ));
				}
			} else {
				actPath.removeLast();
			}
			res.setDb(res.getDb() + 1);
		}
	}
	
	@Override
	public String res() {
		
		return String.valueOf(res.getStop()-res.getStart() + "\n" + res.getDb());
	}

}
