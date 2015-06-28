package hu.unideb.inf.ai2011.problems.queen;

import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.State;

public class QueenOperator implements Operator {

	int row; // 1, 2, ..., 8
	
	@Override
	public String toString() {
		return "TablaOperator [row=" + row + "]";
	}

	public QueenOperator(int row) {
		this.row = row;
	}

	@Override
	public State apply(State s) {
		QueenState state = (QueenState)s;
		int column = 0;
		for ( int i = 1; i <= Main.n; i++ )
			for ( int j = 1; j <= Main.n; j++ )
				column += state.cell(i, j);
		column += 1;

		QueenState newState = new QueenState();
		for ( int i = 1; i <= Main.n; i++ )
			for ( int j = 1; j <= Main.n; j++ )
				newState.chessTable[i-1][j-1] =
					(i==row && j==column) ? 1 : state.cell(i, j);
		
		return newState;
	}

	@Override
	public boolean isApplicable(State s) {
		QueenState state = (QueenState)s;
		int column = 0;
		for ( int i = 1; i <= Main.n; i++ )
			for ( int j = 1; j <= Main.n; j++ )
				column += state.cell(i, j);
		column += 1;
		
		for ( int i = 1; i<=Main.n; i++ )
			if ( state.cell(row, i) == 1 )
				return false;
		
		for ( int u = 1; u <= Main.n; u++ )
			for ( int w = 1; w <= Main.n; w++ )
				if ( state.cell(u, w) == 1 && Math.abs(u-row) == Math.abs(w-column) )
					return false;
		
		return true;
	}

}
