package collectionsComparation;

public class TestResults {
	

	private long db;
	private long ArrayListResult;
	private long LinkedListResult;

	public TestResults(long linkedListResult,long arrayListResult, long db) {

		this.ArrayListResult = arrayListResult;
		this.LinkedListResult = linkedListResult;
		this.db = db;
	}

	@Override
	public String toString() {
		return ArrayListResult + ";" + LinkedListResult;
	}
	public long getArrayListResult() {
		return ArrayListResult;
	}

	public long getLinkedListResult() {
		return LinkedListResult;
	}
}
