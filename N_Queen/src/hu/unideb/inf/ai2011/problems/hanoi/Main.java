package hu.unideb.inf.ai2011.problems.hanoi;

//import java.util.Scanner;

//import hu.unideb.inf.ai2011.Operator;
import hu.unideb.inf.ai2011.Problem;
//import hu.unideb.inf.ai2011.State;
import hu.unideb.inf.ai2011.algorithms.BackTrack;
import hu.unideb.inf.ai2011.algorithms.TrialAndError;

public class Main {

	public static void main(String[] args) {
		Problem p = new HanoiProblem();
		
//		BackTrack alg = new BackTrack(p);
		TrialAndError alg = new TrialAndError(p);
		
		if ( alg.run() ) {
			System.out.println( alg.getGoal() );
		} 
		else {
			System.out.println("No solutions found.");
		}
		
//		State hs = p.startState();
//		Scanner sc = new Scanner(System.in);
//		Operator op = null;
//		int u, w;
//		
//		while (!hs.isGoal()) {
//			System.out.println(hs);
//			System.out.print("Next step: ");
//			
//			u = sc.nextInt();
//			w = sc.nextInt();
//			op = new HanoiOperator(u, w);
//			
//			if (u >= 1 && u <= 4 && w >= 1 && w <= 4 && op.isApplicable(hs)) {
//				hs = op.apply(hs);
//				System.out.println("Applied operator: " + op);
//			}
//			else {
//				System.out.println("Not applicable operator: " + op);
//			}
//		}		
//		
//		System.out.printf("Solution found: " + hs);
	}

}
