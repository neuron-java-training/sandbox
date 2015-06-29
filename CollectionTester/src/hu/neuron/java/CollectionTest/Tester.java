package hu.neuron.java.CollectionTest;

public abstract class Tester implements TesterInterface{

	private String testName = null;

	public Tester(String testName) {
		super();
		this.testName = testName;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}	
}
