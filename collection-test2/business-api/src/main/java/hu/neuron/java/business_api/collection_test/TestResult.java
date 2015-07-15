package hu.neuron.java.business_api.collection_test;

import java.io.Serializable;

public class TestResult implements Serializable {

	private static final long serialVersionUID = 2260840448704309708L;

	private String testName;
	private long initTime;
	private long accessTime;
	private long deleteTime;
	private long sortTime;

	public TestResult() {
	}
	
	public TestResult(String testName) {
		super();
		this.testName = testName;
	}
	
	public long getInitTime() {
		return initTime;
	}

	public void setInitTime(long initTime) {
		this.initTime = initTime;
	}

	public long getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(long accessTime) {
		this.accessTime = accessTime;
	}

	public long getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(long deleteTime) {
		this.deleteTime = deleteTime;
	}

	public long getSortTime() {
		return sortTime;
	}

	public void setSortTime(long sortTime) {
		this.sortTime = sortTime;
	}

	public String getTestName() {
		return testName;
	}
	
	public void setTestName(String testName) {
		this.testName = testName;
	}

	@Override
	public String toString() {
		return testName + ":  initTime=" + initTime + ", accessTime=" + accessTime + ", deleteTime=" + deleteTime + ", sortTime=" + sortTime;
	}

}
