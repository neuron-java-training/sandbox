package neuron3ora.feladat8Kiralyno;

import java.util.ArrayList;

public class Main {
	static private int tableSize = 0;

	public static void main(String[] args) {
		ArrayList<QueenResult> qResult = new ArrayList<QueenResult>();
		QueenResult qResultRow = new QueenResult();
		long timer = 0;

		tableSize = 9;
		System.out.println(tableSize + " tablameret " + tableSize + " kiralyno test");

		System.out.println("BackTrack...");
		qResultRow = new QueenResult();
		qResultRow.setTablesize(tableSize);
		qResultRow.setName("BackTrack");
		timer = System.currentTimeMillis();
		QueenProblem problem = new QueenProblem();
		BackTrack algorithm = new BackTrack(problem);
		algorithm.run();
		System.out.println(algorithm.getGoal());
		qResultRow.setRuntime(System.currentTimeMillis() - timer);
		qResult.add(qResultRow);

		System.out.println("BreadthFirstSearch...");
		qResultRow = new QueenResult();
		qResultRow.setTablesize(tableSize);
		qResultRow.setName("BreadthFirstSearch");
		timer = System.currentTimeMillis();
		QueenProblem problem2 = new QueenProblem();
		BreadthFirstSearch algorithm2 = new BreadthFirstSearch(problem2);
		algorithm2.run();
		System.out.println(algorithm2.getGoal());
		qResultRow.setRuntime(System.currentTimeMillis() - timer);
		qResult.add(qResultRow);

		System.out.println("TrialAndError...");
		qResultRow = new QueenResult();
		qResultRow.setTablesize(tableSize);
		qResultRow.setName("TrialAndError");
		timer = System.currentTimeMillis();
		QueenProblem problem3 = new QueenProblem();
		TrialAndError algorithm3 = new TrialAndError(problem3);
		algorithm3.run();
		System.out.println(algorithm3.getGoal());
		qResultRow.setRuntime(System.currentTimeMillis() - timer);
		qResult.add(qResultRow);

		// kiertekeles
		System.out.println("Test kiertekelese: ");
		for (QueenResult row : qResult) {
			row.getResult();
		}
	}

	public static int getTableSize() {
		return tableSize;
	}

	public void setTableSize(int tableSize) {
		this.tableSize = tableSize;
	}

}
