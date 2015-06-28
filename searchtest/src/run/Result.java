package run;

public class Result {
	private long start;
	private long stop;
	int db = 0;
	public int getDb() {
		return db;
	}


	public void setDb(int db) {
		this.db = db;
	}


	public Result(long start, long stop) {
		super();
		this.start = start;
		this.stop = stop;
	}
	
	
	public Result() {
		super();
	}
	
	
	public long getStart() {
		return start;
	}
	public void setStart(long start) {
		this.start = start;
	}
	public long getStop() {
		return stop;
	}
	public void setStop(long stop) {
		this.stop = stop;
	}

}
