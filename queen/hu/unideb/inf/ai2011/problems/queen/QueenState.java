package hu.unideb.inf.ai2011.problems.queen;

import hu.unideb.inf.ai2011.State;

public class QueenState implements State {
	
	byte[][] chessTable = new byte[8][8];

	public byte cell( int row, int col) {
		return chessTable[row-1][col-1];
	}
	
	@Override
	public boolean isGoal() {
		int sum = 0;
		for ( int i = 1; i <= 8; i++ )
			for ( int j = 1; j <= 8; j++ )
				sum += cell(i,j);
		return sum == 8;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for ( int i = 1; i <= 8; i++ ) {
			for ( int j = 1; j <= 8; j++ )
				sb.append( cell(i,j) == 1 ? "[]" : ". ");
			sb.append("\n");	
		}
		return sb.toString();
	}
	
	

}
