package common.collection_test;

public abstract class Tester implements TesterInterface{

//	public static final int LIST_SIZE = 1_000_000;
//	public static final int TEST_SIZE = 1_000;
	
	protected int initSize;
	protected int testSize;
	
	public Tester(int listSize, int testSize) {
		super();
		this.initSize = listSize;
		this.testSize = testSize;
	}

	
	public abstract String getTestName();

	public int getInitSize() {
		return initSize;
	}


	public void setInitSize(int initSize) {
		this.initSize = initSize;
	}


	public int getTestSize() {
		return testSize;
	}


	public void setTestSize(int testSize) {
		this.testSize = testSize;
	}
	
	
}
