package hu.neuron.java.project.core;

public class AverageResult implements Comparable<AverageResult>{
	
	private double initTime = 0;
	private double fillTime = 0;
	private double sortTime = 0;
	private double accessTime = 0;
	private double deletionTime = 0;
	private double duplicateEliminationTime = 0;
	private String collectionName;
	private int accessCounter = 0;
	private int n = 0;

	public double getAverageInitTime() {
		return initTime / n;
	}

	public void addInitTime(long time) {
		accessCounter++;
		calculateN();
		initTime += time;
	}

	public double getAverageFillTime() {
		return fillTime / n;
	}

	public void addFillTime(long time) {
		accessCounter++;
		calculateN();
		fillTime += time;
	}

	public double getAverageSortTime() {
		return sortTime / n;
	}

	public void addSortTime(long time) {
		accessCounter++;
		calculateN();
		sortTime += time;
	}

	public double getAverageAccessTime() {
		return accessTime / n;
	}

	public void addAccessTime(long time) {
		accessCounter++;
		calculateN();
		accessTime += time;
	}

	public double getAverageDeletionTime() {
		return deletionTime / n;
	}

	public void addDeletionTime(long time) {
		accessCounter++;
		calculateN();
		deletionTime += time;
	}

	public double getAverageDuplicateEliminationTime() {
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
