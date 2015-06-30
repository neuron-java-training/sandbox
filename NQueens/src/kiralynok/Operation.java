package kiralynok;

import allapotter.Operator;

public class Operation extends Operator{
	
	//private int sor;
	private int oszlop;
	
	/*public Operation(int x, int y){
		sor = x;
		oszlop = y;
	}*/
	
	public Operation(int y){
		oszlop = y;
	}

	/*public int getSor() {
		return sor;
	}

	public void setSor(int sor) {
		this.sor = sor;
	}*/

	public int getOszlop() {
		return oszlop;
	}

	public void setOszlop(int oszlop) {
		this.oszlop = oszlop;
	}

	/*public String toString(){
		return "Op: [" + sor + "," + oszlop + "]";
	}*/
	
	public String toString(){
		return "Op: [" + oszlop + "]";
	}
	
}
