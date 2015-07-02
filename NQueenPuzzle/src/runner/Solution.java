package runner;

import java.util.List;

import queenPuzzle.Operator;

public class Solution {

	private List<Operator> solution = null;
        private String name = null;
        private int instances = 0;
        private long runTime = 0;
	
	public Solution(List<Operator> solution, long runTime, int instances, String name) {
		super();
		this.solution = solution;
		this.name = name;
                this.instances = instances;
                this.runTime = runTime;
	}
	
	public void printSolution(){
		for (Operator op : solution) {
			System.out.println(op);
		}
	}
	
	private String getRowSeparator(){
		String separator = "";
		for (int i = 0; i < solution.size()+1 ; i++) {
			separator += "|---";
		}
		return separator.substring(0, separator.length()-3);
	}
	
	public void printSolutionTable(){
		int n = solution.size();
		System.out.println(getRowSeparator());
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(solution.contains(new Operator(i, j))){
					System.out.print("| Q ");
				}else{
					System.out.print("|   ");
				}
			}
			System.out.println("|");
			System.out.println(getRowSeparator());
		}
                System.out.println("\n Time: " + runTime + " Nodes: " + instances);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
