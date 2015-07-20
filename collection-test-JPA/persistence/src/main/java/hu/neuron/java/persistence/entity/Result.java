package hu.neuron.java.persistence.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="results")
@NamedQueries({
	@NamedQuery(name="Result.findAll", query="SELECT r FROM Result r"),
	@NamedQuery(name="Result.findByName", query="SELECT r FROM Result r WHERE r.name = :name")
})
public class Result extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long accessTime;

	private Long deleteTime;

	private Long initTime;

	private String name;

	private Long sortTime;

	public Result() {
	}

	public Long getAccessTime() {
		return this.accessTime;
	}

	public void setAccessTime(Long accessTime) {
		this.accessTime = accessTime;
	}

	public Long getDeleteTime() {
		return this.deleteTime;
	}

	public void setDeleteTime(Long deleteTime) {
		this.deleteTime = deleteTime;
	}

	public Long getInitTime() {
		return this.initTime;
	}

	public void setInitTime(Long initTime) {
		this.initTime = initTime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSortTime() {
		return this.sortTime;
	}

	public void setSortTime(Long sortTime) {
		this.sortTime = sortTime;
	}

}