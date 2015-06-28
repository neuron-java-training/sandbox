package algorithms;

import hu.unideb.inf.ai2011.State;

public interface Search {
	
	public State getGoal();
	public boolean run();
	
	public String res();

}
