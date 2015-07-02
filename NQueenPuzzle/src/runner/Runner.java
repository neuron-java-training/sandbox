package runner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import queenPuzzle.Operator;

import queenPuzzle.StateSpace;
import solver.BackTrack.BackTrack;
import solver.GraphBased.BreadthFirstSearch.BreadthFirstSearch;
import solver.GraphBased.DeptFirstSearch.DeptFirstSearch;
import solver.QueenPuzzleSolver;

public class Runner {

    private List<QueenPuzzleSolver> solvers = null;
    private List<Solution> solutions = null;
    private StateSpace stateSpace = null;

    public Runner(StateSpace stateSpace) {
        super();
        this.stateSpace = stateSpace;
        this.solutions = new ArrayList<>();
        this.solvers = new ArrayList<>();
    }

    public void addSolver(QueenPuzzleSolver solver) {
        this.solvers.add(solver);
    }

    public void run() {
        for (QueenPuzzleSolver solver : solvers) {
            Date start = new Date();
            List<Operator> listOfOperators = solver.search(stateSpace);
            Date end = new Date();
            Long runTime = end.getTime()-start.getTime();
            solutions.add(new Solution(listOfOperators, runTime, solver.getInstances(), solver.getSolverName()));
        }
    }

    public void printSolutionTables() {
        for (Solution solution : solutions) {
            System.out.println(solution.getName() + ":");
            solution.printSolutionTable();
        }
    }

    public static void main(String[] args) {
        Runner runner = new Runner(new StateSpace(13));
		runner.addSolver(new DeptFirstSearch());
        runner.addSolver(new BreadthFirstSearch());
        runner.addSolver(new BackTrack());

        runner.run();

        runner.printSolutionTables();
    }

}
