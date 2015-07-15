package hu.neuron.java.business_api.collection_test;

import java.util.List;

public interface CollectionTesterInterface {

	public List<TestResult> run(int initSize, int testSize);
	
	public List<TestResult> getAverageOfResult();
	
}
