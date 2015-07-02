package queenPuzzle;

import java.util.List;

public class Operator implements OperatorInterface{

	private int row = 0;
	private int col = 0;
	
	public Operator(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
	
	@Override
	public boolean isApplicable(State state){
		List<Queen> queens = state.getPositionOfQueens();
		
		for (Queen queen : queens) {
			//row and coll check
			if(queen.getCol() == col || queen.getRow() == row){
				return false;
			}			
			
			//diagonal check
			int colDif = Math.abs(queen.getCol() - col);
			int rowDif = Math.abs(queen.getRow() - row);
			if(colDif == rowDif){
				return false;
			}
		}
		
		return true;
	}
	
	@Override
	public State apply(State state){
		State newState = new State(state);
		newState.addQueen(new Queen(row, col));
		return newState;
	}
	
	public int getRow() {
		return row;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public int getCol() {
		return col;
	}
	
	public void setCol(int col) {
		this.col = col;
	}

	@Override
	public String toString() {
		return "Operator [row=" + (row) + ", col=" + (col) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
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
		Operator other = (Operator) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
		
}
