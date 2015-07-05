package hu.neuron.java.kollekcio_projekt.common;

/**
 * Osztály egy teszt eredményének kezeléséhez.
 * 
 * @author Norbert
 * 
 */
public class TestResult implements Comparable<TestResult> {
	private String name;
	private long time;

	public String getName() {
		return name;
	}

	public long getTime() {
		return time;
	}

	public TestResult(String name, long time) {
		super();
		this.name = name;
		this.time = time;
	}

	@Override
	public String toString() {
		return name + " " + time;
	}

	@Override
	public int compareTo(TestResult o) {
		if (this.time == o.time) {
			return 0;
		} else if (this.time < o.time) {
			return -1;
		} else {
			return 1;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (time ^ (time >>> 32));
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
		TestResult other = (TestResult) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (time != other.time)
			return false;
		return true;
	}

}
