package hu.neuron.feladat.colltester;

//import hu.neuron.java.collection.ComparableItem;

public class Item implements Comparable<Item> {
	
	private int ID;
	private String name;
	public Item(int iD) {
		super();
		ID = iD;
	}
	public Item(int iD, String name) {
		super();
		ID = iD;
		this.name = name;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
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
		Item other = (Item) obj;
		if (ID != other.ID)
			return false;
		return true;
	}
	@Override
	public int compareTo(Item o) {
		
		return 0;
	}
	
	
	
	
	
	
}
