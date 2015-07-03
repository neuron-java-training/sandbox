package hu.neuron.java.common;

import java.util.List;

import javax.xml.transform.Result;

public interface IOinterface {
	void write(String name, List<Result> myList);
	void delete(String name);
	void read(String name, List<Result> myList);

}
