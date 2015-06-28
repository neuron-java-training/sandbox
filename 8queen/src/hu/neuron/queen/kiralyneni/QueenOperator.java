package hu.neuron.queen.kiralyneni;

import hu.neuron.queen.tools.Operator;
import hu.neuron.queen.tools.State;

public class QueenOperator implements Operator
{

	int row; // 1, 2, ..., 8
	
	public QueenOperator(int row)
	{
		this.row = row;
	}

	@Override
	public State apply(State s)
	{
		QueenState state = (QueenState) s;
		int column = 0;
		for (int i = 1; i <= 8; i++)
		{
			for (int j = 1; j <= 8; j++)
			{
				column += state.cell(i, j);
			}
		}
		column += 1;

		QueenState newState = new QueenState();
		for (int i = 1; i <= 8; i++)
		{
			for (int j = 1; j <= 8; j++)
			{
				newState.chessTable[i - 1][j - 1] = (i == row && j == column) ? 1 : state
						.cell(i, j);
			}
		}
		return newState;
	}

	@Override
	public boolean isApplicable(State s)
	{
		QueenState state = (QueenState) s;
		int column = 0;
		for (int i = 1; i <= 8; i++)
		{
			for (int j = 1; j <= 8; j++)
			{
				column += state.cell(i, j);
			}
		}
		column += 1;

		for (int i = 1; i <= 8; i++)
		{
			if (state.cell(row, i) == 1)
			{
				return false;
			}
		}

		for (int u = 1; u <= 8; u++)
		{
			for (int w = 1; w <= 8; w++)
			{
				if (state.cell(u, w) == 1 && Math.abs(u - row) == Math.abs(w - column))
				{
					return false;
				}
			}
		}

		return true;
	}

}
