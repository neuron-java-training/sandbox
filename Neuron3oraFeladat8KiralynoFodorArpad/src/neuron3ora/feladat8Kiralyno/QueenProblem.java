package neuron3ora.feladat8Kiralyno;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class QueenProblem implements Problem {

	static private int tableSize = Main.getTableSize()>0 ? Main.getTableSize(): 8;;

	static Set<Operator> operators = new HashSet<Operator>();
	static {
		
		for(int i=1;i<=tableSize;i++){
			operators.add(new QueenOperator(i,tableSize));
		}
//		operators.add(new QueenOperator(1,tableSize));
//		operators.add(new QueenOperator(2,tableSize));
//		operators.add(new QueenOperator(3,tableSize));
//		operators.add(new QueenOperator(4,tableSize));
//		operators.add(new QueenOperator(5,tableSize));
//		operators.add(new QueenOperator(6,tableSize));
//		operators.add(new QueenOperator(7,tableSize));
//		operators.add(new QueenOperator(8,tableSize));
	}

	@Override
	public Collection<Operator> operators() {
		return operators;
	}

	@Override
	public State startState() {
		return new QueenState();
	}

}
