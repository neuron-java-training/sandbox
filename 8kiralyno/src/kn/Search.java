package kn;

public class Search {

	public Board DFS(Board board) {
		
		board.init();
		
		if (board.IsGoal() == true) {
			board.solutions.add(board);
			return board;
		} else {
			for (int i = 0; i < board.getN(); i++) {
				if (board.isSafe(i)) {
					board.Place(i);
					Board res = DFS(board);
					if (res != null)
						return res;
					board.UnPlace();
				}
			}
		}
		
		System.out.println("Solution time: " + (board.getTime()-System.currentTimeMillis()));
		
		return null;
	}

}
