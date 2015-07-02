package solver.GraphBased.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import queenPuzzle.Operator;
import queenPuzzle.State;
import queenPuzzle.StateSpace;
import solver.GraphBased.GraphNode;
import solver.QueenPuzzleSolver;

public class BreadthFirstSearch extends QueenPuzzleSolver {

    public BreadthFirstSearch() {
        super("BreadthFirstSearch");
    }

    @Override
    public List<Operator> search(StateSpace stateSpace) {
        LinkedList<GraphNode> openNodes = new LinkedList<>();
        openNodes.add(new GraphNode(stateSpace.initialState()));

        while (!openNodes.isEmpty()) {
            GraphNode choosenOne = openNodes.removeFirst();
            if (choosenOne.getState().isFinalSate()) {
                List<Operator> solution = new ArrayList<>();
                while (choosenOne.getParent() != null) {
                    solution.add(0, choosenOne.getProducerOperator());
                    choosenOne = choosenOne.getParent();
                }
                return solution;
            }

            int nextRow = choosenOne.getState().getPositionOfQueens().size();
            List<Operator> operatorList = stateSpace.getListOfOperatorsByRow(nextRow);
            for (Operator op : operatorList) {
                if (op.isApplicable(choosenOne.getState())) {
                    State newState = op.apply(choosenOne.getState());
                    openNodes.addLast(new GraphNode(newState, op, choosenOne));
                    super.incraseInstances();
                }
            }

        }
        return null;
    }
}
