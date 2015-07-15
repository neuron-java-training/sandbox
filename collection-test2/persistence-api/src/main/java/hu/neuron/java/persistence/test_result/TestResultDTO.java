package hu.neuron.java.persistence.test_result;

import java.io.Serializable;

public class TestResultDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String testName;
	private Long initTime;
	private Long accessTime;
	private Long deleteTime;
	private Long sortTime;
	
	public TestResultDTO() {
		super();
	}
	
	public TestResultDTO(Long id, String testName, Long initTime, Long accessTime, Long deleteTime, Long sortTime) {
		super();
		this.id = id;
		this.testName = testName;
		this.initTime = initTime;
		this.accessTime = accessTime;
		this.deleteTime = deleteTime;
		this.sortTime = sortTime;
	}



	public TestResultDTO(String testName) {
		super();
		this.testName = testName;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Long getInitTime() {
		return initTime;
	}

	public void setInitTime(Long initTime) {
		this.initTime = initTime;
	}

	public Long getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(Long accessTime) {
		this.accessTime = accessTime;
	}

	public Long getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Long deleteTime) {
		this.deleteTime = deleteTime;
	}

	public Long getSortTime() {
		return sortTime;
	}

	public void setSortTime(Long sortTime) {
		this.sortTime = sortTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "TestResultDTO [testName=" + testName + ", initTime=" + initTime + ", accessTime=" + accessTime + ", deleteTime=" + deleteTime
				+ ", sortTime=" + sortTime + "]";
	}
}
