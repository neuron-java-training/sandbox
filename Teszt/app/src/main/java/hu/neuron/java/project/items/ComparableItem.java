package hu.neuron.java.project.items;

public class ComparableItem extends Item implements Comparable<ComparableItem> {

	public ComparableItem() {
		super();
	}

	public ComparableItem(String id, String value) {
		super(id, value);
	}

	// @Override
	public int compareTo(ComparableItem o) {
		if (this == o) {
			return 0;
		}
		return getId().compareTo(o.getId());
	}

}
