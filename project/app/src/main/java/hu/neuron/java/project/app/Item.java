package hu.neuron.java.project.app;

public class Item implements Comparable<Item> {
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public Item(int value) {
		super();
		this.value = value;
	}

	public int value;

	
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.getValue(), o.getValue());
	}

}
