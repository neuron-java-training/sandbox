package tester;

public class AverageResult implements Comparable<AverageResult>{
	
	private long initTime = 0;
	private long fillTime = 0;
	private long sortTime = 0;
	private long accessTime = 0;
	private long deletionTime = 0;
	private long duplicateEliminationTime = 0;
	private String collectionName;
	private int accessCounter = 0;
	private int n = 0;

	public long getAverageInitTime() {
		return initTime / n;
	}

	public void addInitTime(long time) {
		accessCounter++;
		calculateN();
		initTime += time;
	}

	public long getAverageFillTime() {
		return fillTime / n;
	}

	public void addFillTime(long time) {
		accessCounter++;
		calculateN();
		fillTime += time;
	}

	public long getAverageSortTime() {
		return sortTime / n;
	}

	public void addSortTime(long time) {
		accessCounter++;
		calculateN();
		sortTime += time;
	}

	public long getAverageAccessTime() {
		return accessTime / n;
	}

	public void addAccessTime(long time) {
		accessCounter++;
		calculateN();
		accessTime += time;
	}

	public long getAverageDeletionTime() {
		return deletionTime / n;
	}

	public void addDeletionTime(long time) {
		accessCounter++;
		calculateN();
		deletionTime += time;
	}

	public long getAverageDuplicateEliminationTime() {
		return duplicateEliminationTime / n;
	}

	public void addDuplicateEliminationTime(long time) {
		accessCounter++;
		calculateN();
		duplicateEliminationTime += time;
	}
	
	public String getCollectionName(){
		return collectionName;
	}
	
	public void setCollectionName(String name){
		collectionName = name;
	}
	
	private void calculateN(){
		if(accessCounter != 0 && accessCounter % 6 == 0){
			n++;
		}
	}
	
	public int getN(){
		return n;
	}
	
	public double getAverageScore(){
		return ((initTime+fillTime+sortTime+accessTime+deletionTime+duplicateEliminationTime)/n)/6;
	}

	@Override
	public int compareTo(AverageResult o) {
		return ((Double)getAverageScore()).compareTo(o.getAverageScore());
	}
}
