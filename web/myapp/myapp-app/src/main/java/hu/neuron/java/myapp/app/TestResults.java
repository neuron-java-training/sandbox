package hu.neuron.java.myapp.app;

import java.io.Serializable;

public class TestResults implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int initTime;
	private String clazzName;

	public TestResults(int initTime, String clazzName) {
		super();
		this.initTime = initTime;
		this.setClazzName(clazzName);
	}

	@Override
	public String toString() {
		return getClazzName() + " >> initalized time: " + initTime
				+ " milisec\n";
	}

	public int getInitTime() {
		return initTime;
	}

	public void setInitTime(int initTime) {
		this.initTime = initTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + initTime;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestResults other = (TestResults) obj;
		if (initTime != other.initTime)
			return false;
		return true;
	}

	public String getClazzName() {
		return clazzName;
	}

	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}

}
