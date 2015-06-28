package kn;

public class Main {

	public static void main(String[] args) {
		Board b = new Board(8);
		new Search().DFS(b);
		
		System.out.println("Solution size: " + b.solutions.size());

		for (int i = 0; i < b.solutions.size(); i++) {
			b.ShowBoard(b.solutions.get(i));
		}
	}

}
