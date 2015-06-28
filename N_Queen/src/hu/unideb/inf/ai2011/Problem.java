package hu.unideb.inf.ai2011;

import java.util.Collection;

public interface Problem {

	State startState();
	
	Collection<Operator> operators();
	
}