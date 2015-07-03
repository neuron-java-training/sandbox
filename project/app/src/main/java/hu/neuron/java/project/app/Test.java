package hu.neuron.java.project.app;

public interface Test {
	String getCollectionName();
	long init();
	long sort();
	long get(int a);
	long delete(int first, int second);
}
