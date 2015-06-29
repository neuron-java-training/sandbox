package queenPuzzle;

import java.util.ArrayList;
import java.util.List;

public class State {

	private List<Queen> positionOfQueens = null;
	private int n = 0;

	public State(int n) {
		super();
		this.n = n;
		this.positionOfQueens = new ArrayList<>();
	}
	
	public State(State state){
		this.positionOfQueens = new ArrayList<>(state.getPositionOfQueens());
		this.n = state.getN();
	}
	
	public void addQueen(Queen queen){
		positionOfQueens.add(queen);
	}
	
	public boolean isFinalSate(){
		return positionOfQueens.size() == n;
	}

	public List<Queen> getPositionOfQueens() {
		return positionOfQueens;
	}

	public void setPositionOfQueens(List<Queen> positionOfQueens) {
		this.positionOfQueens = positionOfQueens;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((positionOfQueens == null) ? 0 : positionOfQueens.hashCode());
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
		State other = (State) obj;
		if (positionOfQueens == null) {
			if (other.positionOfQueens != null)
				return false;
		} else if (!positionOfQueens.equals(other.positionOfQueens))
			return false;
		return true;
	}
	
}
