package queenPuzzle;

public interface OperatorInterface {

	public boolean isApplicable(State state);
	public State apply(State state);
	
}
