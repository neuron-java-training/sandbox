package hu.unideb.inf.ai2011.problems.queen;


public class Result implements Comparable<Result>{
	private String algorithm;
	private long time;
	
	
	public String getAlgorithm() {
		return algorithm;
	}
	
	public long getTime() {
		return time;
	}

	public Result(String algorithm, long time) {
		super();
		this.algorithm = algorithm;
		this.time = time;
	}

	@Override
	public String toString() {
		return "Result [algorithm=" + algorithm + ", time=" + time + "]";
	}

	@Override
	public int compareTo(Result o) {
		if(this.time == o.time){
			return 0;
		}
		else if(this.time < o.time){
			return -1;
		}
		else{
			return 1;
		}
	}
	
	
	

}
