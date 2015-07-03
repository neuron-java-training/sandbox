package hu.neuron.java.project.app;

public class Result {
	public Result() {
		super();
	}
	long sortTime;
	long getTime;
	long deleteTime;
	long initTime;
	String collectionName;
	public long getSortTime() {
		return sortTime;
	}
	public void setSortTime(long sortTime) {
		this.sortTime = sortTime;
	}
	public long getGetTime() {
		return getTime;
	}
	public void setGetTime(long getTime) {
		this.getTime = getTime;
	}
	public long getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(long deleteTime) {
		this.deleteTime = deleteTime;
	}
	public long getInitTime() {
		return initTime;
	}
	public void setInitTime(long initTime) {
		this.initTime = initTime;
	}
	
	public void display() {
		System.out.println("Collection: " + collectionName);
		System.out.println("Creation time: " + initTime );
		System.out.println("Get time: " + getTime);
		System.out.println("Sort time: " + sortTime);
		System.out.println("Deletion time: " + deleteTime);
		
}
	
	public String getCollectionName() {
		return collectionName;
	}
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "CollectionName " + this.getCollectionName() + " DeletionTime " + this.getDeleteTime() + " Sort Time " + this.getDeleteTime() + " getTime " + this.getTime + " initTime " + this.getInitTime(); 
	}
	
	
}
