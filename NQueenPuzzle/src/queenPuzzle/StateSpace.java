package queenPuzzle;

import java.util.ArrayList;
import java.util.List;

public class StateSpace implements StateSpaceInterface{
    
    private State state = null;
    private List<Operator> listOfOperators = null;
    private int n = 0;
    
    public StateSpace(int n) {
        super();
        this.n = n;
        this.state = new State(n);
        this.listOfOperators = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                listOfOperators.add(new Operator(i, j));
                
            }
        }
    }
    
    @Override
    public State initialState() {
        return new State(n);
    }
    
    @Override
    public State getState() {
        return state;
    }
    
    public void setState(State state) {
        this.state = state;
    }
    
    @Override
    public List<Operator> getListOfOperatorsByRow(int row) {
        List<Operator> operatorList = new ArrayList<>();
        for (Operator op : listOfOperators) {
            if (op.getRow() == row) {
                operatorList.add(op);
            }
        }
        
        return operatorList;
    }
    
    @Override
    public List<Operator> getListOfOperators() {
        return listOfOperators;
    }
    
    public void setListOfOperators(List<Operator> listOfOperators) {
        this.listOfOperators = listOfOperators;
    }
    
    @Override
    public int getN() {
        return n;
    }
    
    public void setN(int n) {
        this.n = n;
    }    
}
