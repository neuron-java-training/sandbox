package hu.unideb.inf.ai2011;

public interface Operator {

	boolean isApplicable(State s);
	
	State apply(State s);
	
}
