package hu.neuron.java.project.core;

public class TestResult {
	private String name = "";
	private long initTime = 0;
	private long sortingTime = 0;
	private long getItemTime = 0;
	private long deleteItemsByRangeTime = 0;
	private long duplicationClearTime = 0;

	public TestResult(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	public String getResult() {
		return (name + " ->|initTime-> " + (double) initTime / 1_000_000 + " ms|sortingTime-> "
				+ (double) sortingTime / 1_000_000 + " ms|getItemTime-> " + (double) getItemTime
				/ 1_000_000 + " ms|deleteItemsByRangeTime-> " + (double) deleteItemsByRangeTime
				/ 1_000_000 + " ms|duplicationClearTime-> " + (double) duplicationClearTime / 1_000_000 + " ms|");
	}

	public String getClassMethodUsed() {
		return name;
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

	public long getGetItemTime() {
		return getItemTime;
	}

	public void setGetItemTime(long getItemTime) {
		this.getItemTime = getItemTime;
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

}
