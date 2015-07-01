package tester;

import java.io.FileWriter;
import java.io.IOException;

public class TestResult implements Comparable<TestResult>{
	
	public static final double VIEWRATIO = 100_000d;
	private long initTime;
	private long fillTime;
	private long sortTime;
	private long accessTime;
	private long deletionTime;
	private long duplicateEliminationTime;
	private String collectionName;
	private FileWriter fw;
	
	public TestResult(String name){
		collectionName = name;
	}

	public long getInitTime() {
		return initTime;
	}

	public void setInitTime(long initTime) {
		this.initTime = initTime;
	}

	public long getFillTime() {
		return fillTime;
	}

	public void setFillTime(long fillTime) {
		this.fillTime = fillTime;
	}

	public long getSortTime() {
		return sortTime;
	}

	public void setSortTime(long sortTime) {
		this.sortTime = sortTime;
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

	public long getDuplicateEliminationTime() {
		return duplicateEliminationTime;
	}

	public void setDuplicateEliminationTime(long duplicateEliminationTime) {
		this.duplicateEliminationTime = duplicateEliminationTime;
	}
	
	public double getAverageScore(){
		return (initTime+fillTime+sortTime+accessTime+deletionTime+duplicateEliminationTime)/6;
	}
	
	public String getCollectionName(){
		return collectionName;
	}

	public void display() {
		System.out.println("Collection: " + collectionName);
		System.out.println("Creation time: " + initTime / VIEWRATIO );
		System.out.println("Fill time: " + fillTime / VIEWRATIO);
		System.out.println("Sort time: " + sortTime / VIEWRATIO);
		System.out.println("Access time: " + accessTime / VIEWRATIO);
		System.out.println("Deletion time: " + deletionTime / VIEWRATIO);
		System.out.println("Duplicate elimination time: " + duplicateEliminationTime / VIEWRATIO);
		System.out.println("Average Score: " + getAverageScore() / VIEWRATIO);
		System.out.println();
		
	}

	@Override
	public int compareTo(TestResult o) {
		return ((Double)getAverageScore()).compareTo(o.getAverageScore());
	}
	
	public synchronized void writeToFile(){
		String enter = System.getProperty("line.separator");
			try {
				fw = new FileWriter("results.txt",true);
				fw.write("---" + enter);
				fw.write(collectionName + enter);
				fw.write((initTime/VIEWRATIO) + enter);
				fw.write((fillTime / VIEWRATIO) + enter);
				fw.write((sortTime / VIEWRATIO) + enter);
				fw.write((accessTime / VIEWRATIO) + enter);
				fw.write((deletionTime / VIEWRATIO) + enter);
				fw.write((duplicateEliminationTime / VIEWRATIO) + enter);
				fw.flush();
				fw.close();
			} catch (IOException e) {
			}
	}
}
