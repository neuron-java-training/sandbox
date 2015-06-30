package kiralynok;

import java.util.ArrayList;
import java.util.HashSet;

import finder.Finder;
import allapotter.Allapot;
import allapotter.HibasOperatorException;
import allapotter.Operator;

public class State extends Allapot{
	
	static {
        operatorok = new HashSet<Operator>();
        /*for(int i = 0; i < Finder.N; i++){
			for(int j = 0; j < Finder.N; j++){
				operatorok.add(new Operation(i,j));
			}
		}*/
        for(int i = 0; i < Finder.N; i++){
			operatorok.add(new Operation(i));
		}
    }
	
	private boolean[][] mezo;
	private int oszlop;
	private int sor;
	
	public State(State s){
		mezo = new boolean[Finder.N][Finder.N];
		for(int i = 0; i < Finder.N; i++){
			for(int j = 0; j < Finder.N; j++){
				mezo[i][j] = s.getMezo()[i][j];
			}
		}
	}

	public State(){
		mezo = new boolean[Finder.N][Finder.N];
		for(int i = 0; i < Finder.N; i++){
			for(int j = 0; j < Finder.N; j++){
				mezo[i][j] = false;
			}
		}
		oszlop = -1;
		sor = -1;
	}

	@Override
	public boolean celAllapot() {
		if(sor < Finder.N - 1)
			return false;
		ArrayList<Koordinata> kiralynok = new ArrayList<>(Finder.N);
		for(int i = 0; i < Finder.N; i++){
			for(int j = 0; j < Finder.N; j++){
				if(mezo[i][j] == true){
					kiralynok.add(new Koordinata(i, j));
				}
			}
		}
		for(int i = 0; i< Finder.N; i++){
			for(int j = 0; j< Finder.N; j++){
				if(j == i)
					continue;
				if(kiralynok.get(i).getY() == kiralynok.get(j).getY())
					return false;
				int dx = kiralynok.get(j).getX() - kiralynok.get(i).getX();
				if(kiralynok.get(i).getY() + dx == kiralynok.get(j).getY())
					return false;
				if(kiralynok.get(i).getY() - dx == kiralynok.get(j).getY())
					return false;
			}
		}
		return true;
	}

	@Override
	public boolean elofeltetel(Operator op) throws HibasOperatorException {
//		Operation on = (Operation)op;
//		if(on.getSor() == sor + 1 && on.getOszlop() != oszlop)
//			return true;
//		return false;
		if(sor < Finder.N - 1)
			return true;
		return false;
	}

	@Override
	public Allapot alkalmaz(Operator op) throws HibasOperatorException {
		Operation on = (Operation) op;
		State s = new State(this);
//		s.getMezo()[on.getSor()][on.getOszlop()] = true;
//		s.setOszlop(on.getOszlop());
//		s.setSor(on.getSor());
		s.getMezo()[sor+1][on.getOszlop()] = true;
		s.setOszlop(on.getOszlop());
		s.setSor(sor+1);
		return s;
	}
	
	public boolean[][] getMezo() {
		return mezo;
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
		for(int i = 0; i < Finder.N; i++){
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
		result.append('\n');
		return result.toString();
	}
	
	
}
