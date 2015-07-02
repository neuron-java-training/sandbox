package hu.neuron.training.kollekciok.test;

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

}
