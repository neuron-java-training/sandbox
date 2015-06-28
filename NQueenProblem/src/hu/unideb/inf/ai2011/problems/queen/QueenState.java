package hu.unideb.inf.ai2011.problems.queen;

import hu.unideb.inf.ai2011.State;

public class QueenState implements State {
	private int size;
	int[][] chessTable; 

	public int cell( int row, int col) {
		return chessTable[row-1][col-1];
	}
	
	@Override
	public boolean isGoal() {
		int sum = 0;
		for ( int i = 1; i <= size; i++ )
			for ( int j = 1; j <= size; j++ )
				sum += cell(i,j);
		return sum == size;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for ( int i = 1; i <= size; i++ ) {
			for ( int j = 1; j <= size; j++ )
				sb.append( cell(i,j) == 1 ? "[]" : ". ");
			sb.append("\n");	
		}
		return sb.toString();
	}

	public QueenState(int size) {
		super();
		this.size = size;
		this.chessTable = new int[size][size];;
	}
	
	

}
