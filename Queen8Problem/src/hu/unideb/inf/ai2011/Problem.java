package hu.unideb.inf.ai2011;

import java.util.Collection;
import java.util.Set;

public interface Problem {

	State startState();
	
	Collection<Operator> operators();
	
}
