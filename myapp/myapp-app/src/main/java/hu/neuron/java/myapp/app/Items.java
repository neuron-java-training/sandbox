package hu.neuron.java.myapp.app;

public class Items implements Comparable<Items>{
	private int values;

	public Items(int values) {
		this.values = values;
	}

	public int getValues() {
		return values;
	}

	public void setValues(int values) {
		this.values = values;
	}

	@Override
	public int compareTo(Items o) {
		return values - o.values;
	}
}
