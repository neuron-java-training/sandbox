package hu.unideb.inf.ai2011.problems.queen;


public class Result implements Comparable<Result> {
	
	String method;
	long ido;
	
	public Result(String method, long ido) {
		super();
		this.method = method;
		this.ido = ido;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public long getIdo() {
		return ido;
	}

	public void setIdo(int ido) {
		this.ido = ido;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Result other = (Result) obj;
		if (ido != other.ido)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Keresõ: " + method + "\t ido=" + ido +"\n";
	}

	@Override
	public int compareTo(Result o) {

		int ertek = (int) ((Result) o).getIdo(); 
 
		//ascending order
		return (int) (this.ido - ertek);
	}
	
	
	
}
