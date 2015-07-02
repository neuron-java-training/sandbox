package solver.BackTrack;

import java.util.ArrayList;
import java.util.List;

import queenPuzzle.Operator;
import queenPuzzle.StateSpace;
import solver.QueenPuzzleSolver;

public class BackTrack extends QueenPuzzleSolver {

    public BackTrack() {
        super("BackTrack");
    }

    @Override
    public List<Operator> search(StateSpace stateSpace) {
        List<BackTrackNode> currentPath = new ArrayList<>();
        currentPath.add(new BackTrackNode(stateSpace.getState(), null, stateSpace));

        if (currentPath.get(0).getState().isFinalSate()) {
            return new ArrayList<>(0);
        }

        while (true) {
            BackTrackNode currentNode = currentPath.get(currentPath.size() - 1);

            if (!currentNode.getUntried().isEmpty()) {
                Operator op = currentNode.getUntried().remove(0);
                BackTrackNode newNode = new BackTrackNode(op.apply(currentNode.getState()), op, stateSpace);
                super.incraseInstances();
                
                currentPath.add(newNode);
                if (newNode.getState().isFinalSate()) {
                    List<Operator> solution = new ArrayList<>(currentPath.size() - 1);
                    for (int i = 1; i < currentPath.size(); i++) {
                        solution.add(currentPath.get(i).getProducerOperator());
                    }
                    return solution;
                }
            } else {
                if (currentPath.size() == 1) {
                    return null;
                } else {
                    currentPath.remove(currentPath.size() - 1);
                }
            }

        }
    }

}
