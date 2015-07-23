package hu.neuron.java.project.common.interfaces;

import java.util.List;

public interface Writer<T> {
	
	public void write();
	
	public void setResults(List<T> list);

}
