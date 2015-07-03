package core.test_result;

import java.io.Serializable;

public class TestResult implements TestResultInterface, Serializable {

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
	
	@Override
	public long getInitTime() {
		return initTime;
	}

	@Override
	public void setInitTime(long initTime) {
		this.initTime = initTime;
	}

	@Override
	public long getAccessTime() {
		return accessTime;
	}

	@Override
	public void setAccessTime(long accessTime) {
		this.accessTime = accessTime;
	}

	@Override
	public long getDeleteTime() {
		return deleteTime;
	}

	@Override
	public void setDeleteTime(long deleteTime) {
		this.deleteTime = deleteTime;
	}

	@Override
	public long getSortTime() {
		return sortTime;
	}

	@Override
	public void setSortTime(long sortTime) {
		this.sortTime = sortTime;
	}

	@Override
	public String getTestName() {
		return testName;
	}

	@Override
	public void setTestName(String testName) {
		this.testName = testName;
	}

	@Override
	public String toString() {
		return testName + ":  initTime=" + initTime + ", accessTime=" + accessTime + ", deleteTime=" + deleteTime + ", sortTime=" + sortTime;
	}

}
