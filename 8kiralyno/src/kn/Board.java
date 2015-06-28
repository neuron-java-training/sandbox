package kn;

import java.util.Arrays;

public class Board implements BoardInterface {
	private int N;
	private int[] board;
	private int cnt;
	private long time;

	public Board(int n) {
		N = n;
		board = new int[N];
		for (int i = 0; i < N; i++)
			board[i] = 0;
		cnt = 0;
	}

	public int getN() {
		return N;
	}

	public void setN(int n) {
		N = n;
	}

	public int[] getBoard() {
		return board;
	}

	public void setBoard(int[] board) {
		this.board = board;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + N;
		result = prime * result + Arrays.hashCode(board);
		result = prime * result + cnt;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (N != other.N)
			return false;
		if (!Arrays.equals(board, other.board))
			return false;
		if (cnt != other.cnt)
			return false;
		return true;
	}
	
	@Override
	public void init() {
		this.setTime(System.currentTimeMillis());
	}

	@Override
	public boolean isSafe(int Clm) {

		for (int i = 0; i < cnt; i++) {
			if ((board[i] == Clm) || Math.abs(Clm - board[i]) == (cnt - i))
				return false;
		}
		return true;
	}

	@Override
	public void Place(int Clm) {
		if (Clm >= 0 && Clm < N) {
			board[cnt] = Clm;
			cnt++;
		} else {
			System.out.println("Bad Column");
		}
	}

	@Override
	public boolean IsGoal() {
		if (cnt == N) {
			return true;
		} else
			return false;
	}

	@Override
	public void UnPlace() {
		if (cnt > 0) {
			cnt--;
		}
	}

	public void ShowBoard(Board board) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (j == board.board[i])
					System.out.print(" 1 ");
				else
					System.out.print(" 0 ");
			}
			System.out.println();
		}
	}

	

}
