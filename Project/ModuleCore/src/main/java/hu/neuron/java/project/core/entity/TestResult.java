package hu.neuron.java.project.core.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TestResult")
public class TestResult implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private long initTime;
	private long sortingTime;
	private long findItemTime;
	private long deleteItemsByRangeTime;
	private long duplicationClearTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getInitTime() {
		return initTime;
	}

	public void setInitTime(long initTime) {
		this.initTime = initTime;
	}

	public long getSortingTime() {
		return sortingTime;
	}

	public void setSortingTime(long sortingTime) {
		this.sortingTime = sortingTime;
	}

	public long getFindItemTime() {
		return findItemTime;
	}

	public void setFindItemTime(long findItemTime) {
		this.findItemTime = findItemTime;
	}

	public long getDeleteItemsByRangeTime() {
		return deleteItemsByRangeTime;
	}

	public void setDeleteItemsByRangeTime(long deleteItemsByRangeTime) {
		this.deleteItemsByRangeTime = deleteItemsByRangeTime;
	}

	public long getDuplicationClearTime() {
		return duplicationClearTime;
	}

	public void setDuplicationClearTime(long duplicationClearTime) {
		this.duplicationClearTime = duplicationClearTime;
	}

	@Override
	public String toString() {
		return "TestResult [id=" + id + ", name=" + name + ", initTime=" + initTime
				+ ", sortingTime=" + sortingTime + ", findItemTime=" + findItemTime
				+ ", deleteItemsByRangeTime=" + deleteItemsByRangeTime + ", duplicationClearTime="
				+ duplicationClearTime + "]";
	}

}
