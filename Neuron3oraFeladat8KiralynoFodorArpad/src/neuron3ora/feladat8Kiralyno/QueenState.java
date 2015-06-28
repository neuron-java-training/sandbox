package neuron3ora.feladat8Kiralyno;

public class QueenState implements State {
	
	private int tableSize = Main.getTableSize()>0 ? Main.getTableSize(): 8;;
	
	byte[][] chessTable = new byte[tableSize][tableSize];

	public byte cell(int row, int col) {
		return chessTable[row - 1][col - 1];
	}

	@Override
	public boolean isGoal() {
		int sum = 0;
		for (int i = 1; i <= tableSize; i++)
			for (int j = 1; j <= tableSize; j++)
				sum += cell(i, j);
		return sum == tableSize;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= tableSize; i++) {
			for (int j = 1; j <= tableSize; j++)
				sb.append(cell(i, j) == 1 ? "[]" : ". ");
			sb.append("\n");
		}
		return sb.toString();
	}

}
