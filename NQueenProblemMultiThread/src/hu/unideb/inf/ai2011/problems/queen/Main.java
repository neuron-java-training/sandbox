package hu.unideb.inf.ai2011.problems.queen;

import hu.unideb.inf.ai2011.Cost;
import hu.unideb.inf.ai2011.Problem;
import hu.unideb.inf.ai2011.algorithms.BackTrack;
import hu.unideb.inf.ai2011.algorithms.BreadthFirstSearch;
import hu.unideb.inf.ai2011.algorithms.OptimalSearch;
import hu.unideb.inf.ai2011.algorithms.TrialAndError;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;

public class Main {
	public static final int QUEEN = 8;

	public static void main(String[] args) {
		
		Thread backTrack = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("backTrack Start");
				Date kezdes;
				Date befejezes;
				long ido;
				Problem problem = new QueenProblem(Main.QUEEN);
				BackTrack algorithm2 = new BackTrack(problem);
				kezdes = new Date();
				algorithm2.run();
				befejezes = new Date();
				ido = befejezes.getTime() - kezdes.getTime();
				algorithm2 = null;
				synchronized (this) {
					try (PrintWriter pw = new PrintWriter(new FileOutputStream("output.txt", true))) {
						pw.println(new Result("BackTrack", ido).toString());
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
				System.out.println("backTrack End");
			}
		});

		Thread trialAndError = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("trialAndError Start");
				Date kezdes;
				Date befejezes;
				long ido;
				Problem problem = new QueenProblem(Main.QUEEN);
				TrialAndError algorithm3 = new TrialAndError(problem);
				kezdes = new Date();
				algorithm3.run();
				befejezes = new Date();
				ido = befejezes.getTime() - kezdes.getTime();
				algorithm3 = null;
				synchronized (this) {
					try (PrintWriter pw = new PrintWriter(new FileOutputStream("output.txt", true))) {
						pw.println(new Result("TrialAndError", ido).toString());
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
				System.out.println("trialAndError End");
			}
		});

		Thread breadthFirstSearch = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("breadthFirstSearch Start");
				Date kezdes;
				Date befejezes;
				long ido;
				Problem problem = new QueenProblem(Main.QUEEN);
				BreadthFirstSearch algorithm4 = new BreadthFirstSearch(problem);
				kezdes = new Date();
				algorithm4.run();
				befejezes = new Date();
				ido = befejezes.getTime() - kezdes.getTime();
				algorithm4 = null;
				synchronized (this) {
					try (PrintWriter pw = new PrintWriter(new FileOutputStream("output.txt", true))) {
						pw.println(new Result("BreadthFirstSearch", ido).toString());
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
				System.out.println("breadthFirstSearch End");
			}
		});

		Thread optimalSearch = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("optimalSearch Start");
				Date kezdes;
				Date befejezes;
				long ido;
				Problem problem = new QueenProblem(Main.QUEEN);
				Cost cost = new QueenCost();
				OptimalSearch algorithm = new OptimalSearch(problem, cost);
				kezdes = new Date();
				algorithm.run();
				befejezes = new Date();
				ido = befejezes.getTime() - kezdes.getTime();
				algorithm = null;
				synchronized (this) {
					try (PrintWriter pw = new PrintWriter(new FileOutputStream("output.txt", true))) {
						pw.println(new Result("OptimalSearch", ido).toString());
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
				System.out.println("optimalSearch End");
			}
		});

		optimalSearch.start();
		trialAndError.start();
		backTrack.start();
		breadthFirstSearch.start();

	}

}
