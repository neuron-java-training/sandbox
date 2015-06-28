package neuron3ora.feladat8Kiralyno;

import java.util.Collection;

public interface Problem {

	State startState();
	
	Collection<Operator> operators();
	
}
