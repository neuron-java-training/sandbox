package hu.neuron.queen.tools;

public interface Operator {

	boolean isApplicable(State s);
	
	State apply(State s);
	
}
