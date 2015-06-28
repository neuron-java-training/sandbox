package neuron3ora.feladat8Kiralyno;

public class QueenResult {
	private String name="";
	private long runtime=0;
	private int tablesize=0;
	
	public void getResult(){
		System.out.println("Tablesize: "+tablesize+" Algorithm: "+name+" Runtime: "+runtime+" ms");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getRuntime() {
		return runtime;
	}

	public void setRuntime(long runtime) {
		this.runtime = runtime;
	}

	public int getTablesize() {
		return tablesize;
	}

	public void setTablesize(int tablesize) {
		this.tablesize = tablesize;
	}
}
