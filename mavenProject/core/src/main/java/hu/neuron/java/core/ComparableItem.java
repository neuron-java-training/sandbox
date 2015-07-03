package hu.neuron.java.core;

public class ComparableItem implements Comparable {

	
	private Integer id;
	private String name;
	
	
	public ComparableItem(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ComparableItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public int compareTo(Object o) {
		
		
		
		
		return 0;
	}
	
	

}
