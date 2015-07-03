package app.collection_element;

public class CollectionElement implements Comparable<CollectionElement> {

	private int id;
	private String value;

	public CollectionElement() {
	}

	public CollectionElement(int id, String value) {
		super();
		this.id = id;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null){
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CollectionElement other = (CollectionElement) obj;
		if (id != other.id) {
			return false;
		}
		if (value == null) {
			if (other.value != null) {
				return false;
			}
		} else if (!value.equals(other.value)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "CollectionElement [id=" + id + ", value=" + value + "]";
	}

	@Override
	public int compareTo(CollectionElement ce) {
		return Integer.compare(this.id, ce.id);
	}
}