package kiralynok;

public class Koordinata {
	
	private int sor;
	private int oszlop;
	
	public Koordinata(int u, int v){
		sor = u;
		oszlop = v;
	}
	
	public int getSor() {
		return sor;
	}
	public void setSor(int x) {
		this.sor = x;
	}
	public int getOszlop() {
		return oszlop;
	}
	public void setOszlop(int y) {
		this.oszlop = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + sor;
		result = prime * result + oszlop;
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
		Koordinata other = (Koordinata) obj;
		if (sor != other.sor)
			return false;
		if (oszlop != other.oszlop)
			return false;
		return true;
	}

	
	
}
