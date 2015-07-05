package hu.neuron.java.common;

import java.util.List;


import hu.neuron.java.project.app.TestingResults;


public interface IOinterface {
	void write(String name, List<TestingResults> myList);
	void delete(String name);
	void read(String name, List<TestingResults> myList);

}
