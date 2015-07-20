package hu.neuron.java.service.vo;

import java.io.Serializable;

public class ResultVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Long initTime;
	private Long accessTime;
	private Long deleteTime;
	private Long sortTime;

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

	public Long getInitTime() {
		return initTime;
	}

	public void setInitTime(Long initTime) {
		this.initTime = initTime;
	}

	public Long getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(Long accessTime) {
		this.accessTime = accessTime;
	}

	public Long getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Long deleteTime) {
		this.deleteTime = deleteTime;
	}

	public Long getSortTime() {
		return sortTime;
	}

	public void setSortTime(Long sortTime) {
		this.sortTime = sortTime;
	}

	@Override
	public String toString() {
		return "ResultVO [id=" + id + ", name=" + name + ", initTime=" + initTime + ", accessTime=" + accessTime + ", deleteTime=" + deleteTime
				+ ", sortTime=" + sortTime + "]";
	}

}
