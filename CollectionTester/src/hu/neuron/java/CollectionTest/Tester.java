package hu.neuron.java.CollectionTest;

public abstract class Tester implements TesterInterface{

	public static final int LIST_SIZE = 1_000_000;
	public static final int TEST_SIZE = 1_000;
	
	public Tester() {
		super();
	}

	public abstract String getTestName();

}
