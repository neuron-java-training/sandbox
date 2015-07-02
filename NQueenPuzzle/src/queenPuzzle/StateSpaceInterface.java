package queenPuzzle;

import java.util.List;

public interface StateSpaceInterface {

	public State initialState();

	public State getState();

	public List<Operator> getListOfOperatorsByRow(int row);

	public List<Operator> getListOfOperators();

	public int getN();

}
