package hu.neuron.java.project.common;

import java.io.Serializable;

public class Result implements Serializable, Comparable<Result> {
	
	
	private long init;
	private long sort;
	private long getElement;
	private long delete;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Result() {

	}

	public long getInit() {
		return init;
	}

	public void setInit(long init) {
		this.init = init;
	}

	public long getSort() {
		return sort;
	}

	public void setSort(long sort) {
		this.sort = sort;
	}

	public long getGetElement() {
		return getElement;
	}

	public void setGetElement(long getElement) {
		this.getElement = getElement;
	}

	public long getDelete() {
		return delete;
	}

	public void setDelete(long delete) {
		this.delete = delete;
	}

	@Override
	public String toString() {
		return "Result [init=" + init + ", sort=" + sort + ", getElement="
				+ getElement + ", delete=" + delete + ", name=" + name + "]";
	}

	public String res() {
		return name + ", "+ init + ", " + sort + ", " + getElement + ", " + delete;
	}

	public int compareTo(Result o) {
		if(this.name.compareTo(o.name) > 0)
			return 1;
		else if(this.name.compareTo(o.name) < 0)
			return -1;
		else
			return 0;
	}
	

	
	
	
	
	
	

}
