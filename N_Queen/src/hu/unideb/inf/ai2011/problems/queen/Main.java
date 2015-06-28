package hu.unideb.inf.ai2011.problems.queen;

import hu.unideb.inf.ai2011.algorithms.ABasic;
import hu.unideb.inf.ai2011.algorithms.BackTrack;
import hu.unideb.inf.ai2011.algorithms.BestFirst;
import hu.unideb.inf.ai2011.algorithms.BoundedBackTrack;
import hu.unideb.inf.ai2011.algorithms.BranchAndBound;
import hu.unideb.inf.ai2011.algorithms.BreadthFirst;
import hu.unideb.inf.ai2011.algorithms.DepthFirst;
import hu.unideb.inf.ai2011.algorithms.Optimal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

//import hu.unideb.inf.ai2011.State;
//import hu.unideb.inf.ai2011.algorithms.ABasic;
//import hu.unideb.inf.ai2011.algorithms.BackTrack;
//import hu.unideb.inf.ai2011.algorithms.BestFirst;
//import hu.unideb.inf.ai2011.algorithms.BranchAndBound;
//import hu.unideb.inf.ai2011.algorithms.BreadthFirst;
//import hu.unideb.inf.ai2011.algorithms.DepthFirst;
//import hu.unideb.inf.ai2011.algorithms.Optimal;
//import hu.unideb.inf.ai2011.algorithms.TrialAndError;

public class Main {

	public static int n = 9;
	
	public static void main(String[] args) {
		ArrayList<Result> lista = new ArrayList<Result>();
		QueenProblem problem = new QueenProblem();
		
		BackTrack a01 = new BackTrack(problem);
		Date d1 = new Date();
		a01.run();
		Date d2 = new Date();
		lista.add(new Result("BackTrack", (d2.getTime()-d1.getTime()) ));
		
		BoundedBackTrack a02 = new BoundedBackTrack(problem, 19);	
		d1 = new Date();
		a02.run();
		d2 = new Date();
		lista.add(new Result("BoundedB_T", (d2.getTime()-d1.getTime()) ));
		
		DepthFirst a04 = new DepthFirst(problem);
		d1 = new Date();
		a04.run();
		d2 = new Date();
		lista.add(new Result("DepthFirst", (d2.getTime()-d1.getTime()) ));
		
		BreadthFirst a05 = new BreadthFirst(problem);
		d1 = new Date();
		a05.run();
		d2 = new Date();
		lista.add(new Result("BreadthFirst", (d2.getTime()-d1.getTime()) ));
		
		Optimal a06 = new Optimal(problem);
		d1 = new Date();
		a06.run();
		d2 = new Date();
		lista.add(new Result("Optimal", (d2.getTime()-d1.getTime()) ));
		
		BestFirst a07 = new BestFirst(problem);
		d1 = new Date();
		a07.run();
		d2 = new Date();
		lista.add(new Result("BestFirst", (d2.getTime()-d1.getTime()) ));
		
		ABasic algorithm = new ABasic(problem);
		d1 = new Date();
		algorithm.run();
		d2 = new Date();
//		System.out.println((d2.getTime()-d1.getTime()));
		lista.add(new Result("ABasic", (d2.getTime()-d1.getTime()) ));
		

		BranchAndBound a03 = new BranchAndBound(problem, 15);
		d1 = new Date();
		a03.run();
		d2 = new Date();
		lista.add(new Result("Branch&Bound", (d2.getTime()-d1.getTime()) ));
//		System.out.println(algorithm.getSolution());
//		algorithm.printSolution();
//		System.out.println( algorithm.getGoal() );	
		Collections.sort(lista);
		System.out.println(lista);
	}
}
