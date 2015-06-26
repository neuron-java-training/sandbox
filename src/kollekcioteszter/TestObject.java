package kollekcioteszter;

public class TestObject implements Comparable<TestObject>{

	private long creationTime;
	private String name;
	
	public TestObject(){
		creationTime = System.nanoTime();
		name = this.toString();
	}
	
	public TestObject(TestObject to){
		creationTime = to.getCreationTime();
		name = to.getName();
	}
	
	public Long getCreationTime(){
		return creationTime;
	}
	
	public String getName(){
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (creationTime ^ (creationTime >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		TestObject other = (TestObject) obj;
		if (creationTime != other.creationTime)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(TestObject other) {
		if(other != null){
			return ((Long)creationTime).compareTo(other.getCreationTime());
		}
		return -1;
	}
	
}
