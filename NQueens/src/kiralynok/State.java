package kiralynok;

import java.util.ArrayList;
import java.util.HashSet;

import finder.TestRunner;
import allapotter.Allapot;
import allapotter.HibasOperatorException;
import allapotter.Operator;

public class State extends Allapot{
	
	static {
        operatorok = new HashSet<Operator>();
        for(int i = 0; i < TestRunner.N; i++){
			for(int j = 0; j < TestRunner.N; j++){
				operatorok.add(new Operation(i,j));
			}
		}
    }
	
	private boolean[][] mezo;
	private int oszlop;
	private int sor;
	
	public State(State s){
		mezo = new boolean[TestRunner.N][TestRunner.N];
		for(int i = 0; i < TestRunner.N; i++){
			for(int j = 0; j < TestRunner.N; j++){
				mezo[i][j] = s.getMezo()[i][j];
			}
		}
	}

	public State(){
		mezo = new boolean[TestRunner.N][TestRunner.N];
		for(int i = 0; i < TestRunner.N; i++){
			for(int j = 0; j < TestRunner.N; j++){
				mezo[i][j] = false;
			}
		}
		oszlop = -1;
		sor = -1;
	}

	@Override
	public boolean celAllapot() {
		ArrayList<Koordinata> kiralynok = new ArrayList<>(TestRunner.N);
		for(int i = 0; i < TestRunner.N; i++){
			for(int j = 0; j < TestRunner.N; j++){
				if(mezo[i][j] == true){
					kiralynok.add(new Koordinata(i, j));
				}
			}
		}
		if(kiralynok.size() == TestRunner.N){
			for(int i = 0; i< TestRunner.N; i++){
				for(int j = 0; j< TestRunner.N; j++){
					if(j == i)
						continue;
					if(kiralynok.get(i).getY() == kiralynok.get(j).getY())
						return false;
					int dx = kiralynok.get(j).getX() - kiralynok.get(i).getX();
					if(kiralynok.get(i).getY() + dx == kiralynok.get(j).getY())
						return false;
					if(kiralynok.get(i).getY() - dx == kiralynok.get(j).getY())
						return false;
					/*if((kiralynok.get(i).getX() - kiralynok.get(j).getX()) == 
							(kiralynok.get(i).getY() - kiralynok.get(j).getY())){
						System.out.println("I. x: "+kiralynok.get(i).getX() +
								" y: " +kiralynok.get(i).getY() + 
								" II. x: " +kiralynok.get(j).getX() +
								" y: " +kiralynok.get(j).getY());
						return false;
					}	*/
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean elofeltetel(Operator op) throws HibasOperatorException {
		Operation on = (Operation)op;
		if(on.getSor() == sor + 1 && on.getOszlop() != oszlop)
			return true;
		return false;
	}

	@Override
	public Allapot alkalmaz(Operator op) throws HibasOperatorException {
		Operation on = (Operation) op;
		State s = new State(this);
		s.getMezo()[on.getSor()][on.getOszlop()] = true;
		s.setOszlop(on.getOszlop());
		s.setSor(on.getSor());
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
		for(int i = 0; i < TestRunner.N; i++){
			for(int j = 0; j < TestRunner.N; j++){
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
