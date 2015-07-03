package queens;

public interface QueensInterface {
	public abstract void initBoard(char[][] board);

	public abstract void displayBoard(char[][] board);

	public abstract boolean safe(char[][] board, int row, int col);

	public abstract boolean completeBoard(char[][] board);
}
