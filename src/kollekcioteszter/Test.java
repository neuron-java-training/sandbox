package kollekcioteszter;

public interface Test {
	
	public long creationTest();
	public long fillTest();
	public long sortTest();
	public long accessTest(int elementNumber);
	public long deletionTest(int first, int last);
	public long removeDuplicates();
	public String getCollectionName();

}
