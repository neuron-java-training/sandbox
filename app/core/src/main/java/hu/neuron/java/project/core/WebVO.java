package hu.neuron.java.project.core;

import java.io.Serializable;

public class WebVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3332164325689769177L;
	private String className;
	private int n;
	private double accessTime;
	private double deletionTime;
	private double duplicateTime;
	private double fillTime;
	private double initTime;
	private double sortTime;
	
	public WebVO(){}

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
	public double getAccessTime() {
		return accessTime;
	}
	public void setAccessTime(double accessTime) {
		this.accessTime = accessTime;
	}
	public double getDeletionTime() {
		return deletionTime;
	}
	public void setDeletionTime(double deletionTime) {
		this.deletionTime = deletionTime;
	}
	public double getDuplicateTime() {
		return duplicateTime;
	}
	public void setDuplicateTime(double duplicateTime) {
		this.duplicateTime = duplicateTime;
	}
	public double getFillTime() {
		return fillTime;
	}
	public void setFillTime(double fillTime) {
		this.fillTime = fillTime;
	}
	public double getInitTime() {
		return initTime;
	}
	public void setInitTime(double initTime) {
		this.initTime = initTime;
	}
	public double getSortTime() {
		return sortTime;
	}
	public void setSortTime(double sortTime) {
		this.sortTime = sortTime;
	}
}
