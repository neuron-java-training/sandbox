package neuron3ora.feladat8Kiralyno;

public interface Operator {

	boolean isApplicable(State s);
	
	State apply(State s);
	
}
