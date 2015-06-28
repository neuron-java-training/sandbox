package algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import run.Result;
import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.State;

public class TrialAndError implements Search {

	private Problem p;
	Result res = new Result();
	
	public TrialAndError( Problem p ) {
		res.setStart(System.currentTimeMillis());
		this.p = p;
	}
	
	private State current = null;
	
	@Override
	public boolean run() {
		Random r = new Random();
		current = p.startState();
		while ( true ) {
			if ( current.isGoal() ) {
				res.setStop(System.currentTimeMillis());
				return true;
			}
			List<Operator> ops = new ArrayList<Operator>();
			for ( Operator o : p.operators() )
				if ( o.isApplicable(current) )
					ops.add(o);
			if ( ! ops.isEmpty() ) {
				Operator o = ops.get(r.nextInt(ops.size()));
				current = o.apply(current);
			} else {
				res.setStop(System.currentTimeMillis());
				return false;
			}	
			res.setDb(res.getDb() + 1);
		}
	}

	@Override
	public State getGoal() {
		return current.isGoal() ? current : null;
	}

	@Override
	public String res() {
		return String.valueOf(res.getStop()-res.getStart() + "\n" + res.getDb());
	}
}
