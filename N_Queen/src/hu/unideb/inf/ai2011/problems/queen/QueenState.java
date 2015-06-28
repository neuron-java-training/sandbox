package hu.unideb.inf.ai2011.problems.queen;

import hu.unideb.inf.ai2011.HeuristicState;
import hu.unideb.inf.ai2011.State;

import java.util.Arrays;

public class QueenState implements State, HeuristicState {
	
	byte[][] chessTable = new byte[Main.n][Main.n];

	public byte cell( int row, int col) {
		return chessTable[row-1][col-1];
	}
	
	@Override
	public boolean isGoal() {
		int sum = 0;
		for ( int i = 1; i <= Main.n; i++ )
			for ( int j = 1; j <= Main.n; j++ )
				sum += cell(i,j);
		return sum == Main.n;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for ( int i = 1; i <= Main.n; i++ ) {
			for ( int j = 1; j <= Main.n; j++ )
				sb.append( cell(i,j) == 1 ? "[]" : ". ");
			sb.append("\n");	
		}
		return sb.toString();
	}

	@Override
	public double heuristic() {
		int result = 0;
		for (int i = 1; i <= Main.n; i++) {
			for (int j = 1; j <= Main.n; j++) {
				if (cell(i, j) == 1) {
					++result;
				}
			}
		}
		return 8-result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(chessTable);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof QueenState)) {
			return false;
		}
		QueenState other = (QueenState) obj;
		if (!Arrays.equals(chessTable, other.chessTable)) {
			return false;
		}
		return true;
	}
}
