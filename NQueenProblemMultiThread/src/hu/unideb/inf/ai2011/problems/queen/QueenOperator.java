package hu.unideb.inf.ai2011.problems.queen;

import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.State;

public class QueenOperator implements Operator {

	int row; // 1, 2, ..., 8
	private int size;
	public QueenOperator(int size, int row) {
		this.row = row;
		this.size = size;
	}

	@Override
	public State apply(State s) {
		QueenState state = (QueenState)s;
		int column = 0;
		for ( int i = 1; i <= size; i++ )
			for ( int j = 1; j <= size; j++ )
				column += state.cell(i, j);
		column += 1;

		QueenState newState = new QueenState(this.size);
		for ( int i = 1; i <= size; i++ )
			for ( int j = 1; j <= size; j++ )
				newState.chessTable[i-1][j-1] =
					(i==row && j==column) ? 1 : state.cell(i, j);
		
		return newState;
	}

	@Override
	public boolean isApplicable(State s) {
		QueenState state = (QueenState)s;
		int column = 0;
		for ( int i = 1; i <= size; i++ )
			for ( int j = 1; j <= size; j++ )
				column += state.cell(i, j);
		column += 1;
		
		for ( int i = 1; i<=size; i++ )
			if ( state.cell(row, i) == 1 )
				return false;
		
		for ( int u = 1; u <= size; u++ )
			for ( int w = 1; w <= size; w++ )
				if ( state.cell(u, w) == 1 && Math.abs(u-row) == Math.abs(w-column) )
					return false;
		
		return true;
	}

}
