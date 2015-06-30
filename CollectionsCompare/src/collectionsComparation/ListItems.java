package collectionsComparation;

public class ListItems implements Comparable<ListItems> {
	public int value;

	public ListItems(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Generated value: " + value;
	}

	@Override
	public int compareTo(ListItems list) {
		int compare = (value > list.value) ? 1 : 0;
		if (compare == 0) {
			compare = (value == list.value) ? 0 : -1;
		}
		return compare;
	}
}
