package hu.neuron.java.project.common;

import hu.neruon.java.project.app;

import java.util.List;
import java.util.Set;

public interface Test<E extends Set<?> & List<?>> {
	
	void init(E e);
	
	void order();
	
	void getElement(String a);
	
	void delete(int a, int b);
	
	void TimeCounter();
	
}

