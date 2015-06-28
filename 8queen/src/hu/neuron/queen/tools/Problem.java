package hu.neuron.queen.tools;

import java.util.Collection;

public interface Problem {

	State startState();
	
	Collection<Operator> operators();
	
}
