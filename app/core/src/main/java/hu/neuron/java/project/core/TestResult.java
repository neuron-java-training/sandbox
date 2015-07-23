package hu.neuron.java.project.core;

import hu.neuron.java.project.core.entity.BaseEntity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "TestResult")
@NamedQuery(name = "findAllTestResults", query = "select r from TestResult AS r")
public class TestResult extends BaseEntity implements Comparable<TestResult>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final long VIEWRATIO = 100_000;
	private Long initTime;
	private Long fillTime;
	private Long sortTime;
	private Long accessTime;
	private Long deletionTime;
	private Long duplicateEliminationTime;
	private String collectionName;
	
	public TestResult(){}
	
	public TestResult(String name){
		collectionName = name;
	}

	public Long getInitTime() {
		return initTime;
	}

	public void setInitTime(Long initTime) {
		this.initTime = initTime;
	}

	public Long getFillTime() {
		return fillTime;
	}

	public void setFillTime(Long fillTime) {
		this.fillTime = fillTime;
	}

	public Long getSortTime() {
		return sortTime;
	}

	public void setSortTime(Long sortTime) {
		this.sortTime = sortTime;
	}

	public Long getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(Long accessTime) {
		this.accessTime = accessTime;
	}

	public Long getDeletionTime() {
		return deletionTime;
	}

	public void setDeletionTime(Long deletionTime) {
		this.deletionTime = deletionTime;
	}

	public Long getDuplicateEliminationTime() {
		return duplicateEliminationTime;
	}

	public void setDuplicateEliminationTime(Long duplicateEliminationTime) {
		this.duplicateEliminationTime = duplicateEliminationTime;
	}
	
	public double getAverageScore(){
		return (initTime+fillTime+sortTime+accessTime+deletionTime+duplicateEliminationTime)/6;
	}
	
	public String getCollectionName(){
		return collectionName;
	}
	
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	@Override
	public int compareTo(TestResult o) {
		return ((Double)getAverageScore()).compareTo(o.getAverageScore());
	}
}
