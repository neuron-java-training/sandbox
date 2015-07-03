package core.test_result;

public interface TestResultInterface {

	public long getInitTime();

	public void setInitTime(long initTime);

	public long getAccessTime();

	public void setAccessTime(long accessTime);

	public long getDeleteTime();

	public void setDeleteTime(long deleteTime);

	public long getSortTime();

	public void setSortTime(long sortTime);

	public String getTestName();

	public void setTestName(String testName);
	
}
