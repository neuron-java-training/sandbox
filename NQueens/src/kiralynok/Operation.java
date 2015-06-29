package kiralynok;

import allapotter.Operator;

public class Operation extends Operator{
	
	int sor, oszlop;
	
	public Operation(int x, int y){
		sor = x;
		oszlop = y;
	}

	public int getSor() {
		return sor;
	}

	public void setSor(int sor) {
		this.sor = sor;
	}

	public int getOszlop() {
		return oszlop;
	}

	public void setOszlop(int oszlop) {
		this.oszlop = oszlop;
	}

	public String toString(){
		return "Op: [" + sor + "," + oszlop + "]";
	}
	
}
