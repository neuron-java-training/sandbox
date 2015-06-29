package solver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import queenPuzzle.Operator;
import queenPuzzle.State;
import queenPuzzle.StateSpace;

public class BreadthFirstSearch extends QueenPuzzleSolver {

	public BreadthFirstSearch() {
		super("BreadthFirstSearch");
	}

	@Override
	public List<Operator> search(StateSpace stateSpace) {
		LinkedList<GraphNode> openNodes = new LinkedList<GraphNode>();
		LinkedList<GraphNode> closedNodes = new LinkedList<GraphNode>();
		openNodes.add(new GraphNode(stateSpace.initialState()));

		while (!openNodes.isEmpty()) {
			GraphNode choosenOne = openNodes.removeFirst();
			if (choosenOne.getState().isFinalSate()) {
				List<Operator> solution = new ArrayList<Operator>();
				while (choosenOne.getParent() != null) {
					solution.add(0, choosenOne.getProducerOperator());
					choosenOne = choosenOne.getParent();
				}
				return solution;
			}

			closedNodes.add(choosenOne);
			for (Operator op : stateSpace.getListOfOperators()) {
				if (op.isApplicable(choosenOne.getState())) {
					State newState = op.apply(choosenOne.getState());
					openNodes.addLast(new GraphNode(newState, op, choosenOne));
				}
			}

		}
		return null;
	}
}
