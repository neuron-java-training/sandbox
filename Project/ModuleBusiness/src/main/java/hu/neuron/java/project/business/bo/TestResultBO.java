package hu.neuron.java.project.business.bo;

import java.io.Serializable;

public class TestResultBO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id = (long) 0;

	private String name = "";
	private long initTime = 0;
	private long sortingTime = 0;
	private long findItemTime = 0;
	private long deleteItemsByRangeTime = 0;
	private long duplicationClearTime = 0;

	public TestResultBO() {
	}

	public TestResultBO(String name) {
		this.name = name;
	}

	public TestResultBO(long id, String name, long initTime, long sortingTime, long findItemTime,
			long deleteItemsByRangeTime, long duplicationClearTime) {
		this.id = id;
		this.name = name;
		this.initTime = initTime;
		this.sortingTime = sortingTime;
		this.findItemTime = findItemTime;
		this.deleteItemsByRangeTime = deleteItemsByRangeTime;
		this.duplicationClearTime = duplicationClearTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getInitTime() {
		return initTime;
	}

	public void setInitTime(long initTime) {
		this.initTime = initTime;
	}

	public long getSortingTime() {
		return sortingTime;
	}

	public void setSortingTime(long sortingTime) {
		this.sortingTime = sortingTime;
	}

	public long getFindItemTime() {
		return findItemTime;
	}

	public void setFindItemTime(long getItemTime) {
		this.findItemTime = getItemTime;
	}

	public long getDeleteItemsByRangeTime() {
		return deleteItemsByRangeTime;
	}

	public void setDeleteItemsByRangeTime(long deleteItemsByRangeTime) {
		this.deleteItemsByRangeTime = deleteItemsByRangeTime;
	}

	public long getDuplicationClearTime() {
		return duplicationClearTime;
	}

	public void setDuplicationClearTime(long duplicationClearTime) {
		this.duplicationClearTime = duplicationClearTime;
	}

	@Override
	public String toString() {
		return "TestResult [id=" + id + ", name=" + name + ", initTime=" + initTime
				+ ", sortingTime=" + sortingTime + ", findItemTime=" + findItemTime
				+ ", deleteItemsByRangeTime=" + deleteItemsByRangeTime + ", duplicationClearTime="
				+ duplicationClearTime + "]";
	}

}
