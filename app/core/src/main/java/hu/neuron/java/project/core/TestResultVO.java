package hu.neuron.java.project.core;

public class TestResultVO {
	
	private String className;
	private int n;
	private long accessTime;
	private long deletionTime;
	private long duplicateTime;
	private long fillTime;
	private long initTime;
	private long sortTime;
	
	public TestResultVO(){}
	
	public TestResultVO(String name, long init, long fill, long sort, long access, long delete,
			long unduplicate) {
		className=name;
		initTime = init;
		fillTime = fill;
		sortTime = sort;
		accessTime = access;
		deletionTime = delete;
		duplicateTime = unduplicate;
	}

	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public long getAccessTime() {
		return accessTime;
	}
	public void setAccessTime(long accessTime) {
		this.accessTime = accessTime;
	}
	public long getDeletionTime() {
		return deletionTime;
	}
	public void setDeletionTime(long deletionTime) {
		this.deletionTime = deletionTime;
	}
	public long getDuplicateTime() {
		return duplicateTime;
	}
	public void setDuplicateTime(long duplicateTime) {
		this.duplicateTime = duplicateTime;
	}
	public long getFillTime() {
		return fillTime;
	}
	public void setFillTime(long fillTime) {
		this.fillTime = fillTime;
	}
	public long getInitTime() {
		return initTime;
	}
	public void setInitTime(long initTime) {
		this.initTime = initTime;
	}
	public long getSortTime() {
		return sortTime;
	}
	public void setSortTime(long sortTime) {
		this.sortTime = sortTime;
	}
	
	public void display() {
		System.out.println("Collection: " + className);
		System.out.println("Creation time: " + initTime / TestResult.VIEWRATIO );
		System.out.println("Fill time: " + fillTime / TestResult.VIEWRATIO);
		System.out.println("Sort time: " + sortTime / TestResult.VIEWRATIO);
		System.out.println("Access time: " + accessTime / TestResult.VIEWRATIO);
		System.out.println("Deletion time: " + deletionTime / TestResult.VIEWRATIO);
		System.out.println("Duplicate elimination time: " + duplicateTime / TestResult.VIEWRATIO);
		System.out.println();
		
	}
}
