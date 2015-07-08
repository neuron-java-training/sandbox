package hu.neuron.java.myapp.app;


import java.util.Collection;

public interface Test<T extends Collection<Items>> {
	
	void init(T t);
	
	void order();
	
	void getElement(String a);
	
	void delete(int a, int b);
	
	void isBest();
	
}
