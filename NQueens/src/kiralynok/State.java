package kiralynok;

import java.util.ArrayList;
import java.util.HashSet;

import main.Finder;
import allapotter.Allapot;
import allapotter.HibasOperatorException;
import allapotter.Operator;

public class State extends Allapot{
	
	static {
        operatorok = new HashSet<Operator>();
        for(int i = 0; i < Finder.N; i++){
			operatorok.add(new Operation(i));
		}
    }
	
	ArrayList<Koordinata> kiralynok = new ArrayList<>(Finder.N);
	private int oszlop;
	private int sor;
	
	public State(State s){
		kiralynok.addAll(s.getKiralynok());
		allapotok++;
	}

	public State(){
		oszlop = -1;
		sor = -1;
		allapotok++;
	}

	@Override
	public boolean celAllapot() {
		if(sor < Finder.N - 1)
			return false;
		return true;
	}

	@Override
	public boolean elofeltetel(Operator op) throws HibasOperatorException {
		if(sor >= Finder.N - 1)
			return false;
		Operation on = (Operation)op;
		for(Koordinata k : kiralynok){
			if(on.getOszlop() == k.getOszlop())
				return false;
			int dx = (sor+1) - k.getSor();
			if(on.getOszlop() + dx == k.getOszlop())
				return false;
			if(on.getOszlop() - dx == k.getOszlop())
				return false;
		}	
		return true;
	}

	@Override
	public Allapot alkalmaz(Operator op) throws HibasOperatorException {
		Operation on = (Operation) op;
		State s = new State(this);
		s.setOszlop(on.getOszlop());
		s.setSor(sor+1);
		s.getKiralynok().add(new Koordinata(sor+1, on.getOszlop()));
		return s;
	}
	
	public int getOszlop() {
		return oszlop;
	}
	
	public void setOszlop(int oszlop) {
		this.oszlop = oszlop;
	}
	
	public int getSor() {
		return sor;
	}
	
	public void setSor(int sor) {
		this.sor = sor;
	}
	
	@Override
	public String toString(){
		StringBuffer result = new StringBuffer();
		result.append('\n');
		/*for(int i = 0; i < Finder.N; i++){
			for(int j = 0; j < Finder.N; j++){
				if(mezo[i][j] == true){
					result.append("o");
				}
				else{
					result.append("*");
				}
			}
			result.append('\n');
		}
		result.append('\n');*/
		return result.toString();
	}
	
	public ArrayList<Koordinata> getKiralynok(){
		return kiralynok;
	}
}
