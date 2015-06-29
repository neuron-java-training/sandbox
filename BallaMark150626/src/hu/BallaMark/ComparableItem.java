package hu.BallaMark;

public class ComparableItem extends Item implements Comparable<ComparableItem> {

	public ComparableItem(int vaule) {
		super(vaule);
	}

	@Override
	public int compareTo(ComparableItem other) {
		if (other != null) {
			return this.getValue() - other.getValue();
		}
		return -1;
	}
}
