package hu.neuron.java.project.common;

import java.util.List;

public interface Stream {
	void write(List<?> t);
	
	void read();
}
