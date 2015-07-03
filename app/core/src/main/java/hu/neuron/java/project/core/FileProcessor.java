package hu.neuron.java.project.core;

import hu.neuron.java.project.common.interfaces.Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileProcessor implements Reader{
	
	private File file ;
    private Scanner in;
    
    public FileProcessor(){
    	file = new File("results.txt");
    }
    
    public void read(){
    	 try {
 			in = new Scanner(file);
 			LinkedList<TestResult> results = new LinkedList<>();
 			LinkedList<String> names = new LinkedList<>();
 			
 			while(in.hasNextLine()){
 				String line = in.nextLine();
 				while(!line.equals("---")){
 					line = in.nextLine();
 				}
 				String[] block = new String[7];
 				for(int i = 0; i < 7; i++){
 					block[i] = in.nextLine();
 				}

 				if(!names.contains(block[0])){
 					names.add(block[0]);
 				}
 				
 				TestResult tr = new TestResult(block[0]);

 				Double tmp = Double.parseDouble(block[1]);
 				tr.setInitTime((long) (tmp * TestResult.VIEWRATIO));
 				tmp = Double.parseDouble(block[2]);
 				tr.setFillTime((long) (tmp * TestResult.VIEWRATIO));
 				tmp = Double.parseDouble(block[3]);
 				tr.setSortTime((long) (tmp * TestResult.VIEWRATIO));
 				tmp = Double.parseDouble(block[4]);
 				tr.setAccessTime((long) (tmp * TestResult.VIEWRATIO));
 				tmp = Double.parseDouble(block[5]);
 				tr.setDeletionTime((long) (tmp * TestResult.VIEWRATIO));
 				tmp = Double.parseDouble(block[6]);
 				tr.setDuplicateEliminationTime((long) (tmp * TestResult.VIEWRATIO));
 				
 				results.add(tr);		
 			}
 			
 			HashMap<String,List<TestResult>> resultGroups = new HashMap<>();
 			
 			for(String name : names){
 				resultGroups.put(name, new LinkedList<TestResult>());
 			}
 			
 			for(TestResult tr : results){
 				List<TestResult> list = resultGroups.get(tr.getCollectionName());
 				list.add(tr);
 			}
 			
 			LinkedList<AverageResult> averages = new LinkedList<>();
 			
 			for(List<TestResult> l : resultGroups.values()){
 				AverageResult ar = new AverageResult();
 				ar.setCollectionName(l.get(0).getCollectionName());
 				for(TestResult tr : l){
 					ar.addAccessTime(tr.getAccessTime());
 					ar.addDeletionTime(tr.getDeletionTime());
 					ar.addDuplicateEliminationTime(tr.getDuplicateEliminationTime());
 					ar.addFillTime(tr.getFillTime());
 					ar.addInitTime(tr.getInitTime());
 					ar.addSortTime(tr.getSortTime());
 				}
 				averages.add(ar);
 			}
 			
 			Collections.sort(averages);

 			for(AverageResult ar : averages){
 				System.out.println("The average results of " + ar.getN() + " test for");
 				System.out.println(ar.getCollectionName() + " is:");
 				System.out.println("access: " + ar.getAverageAccessTime() / TestResult.VIEWRATIO);
 				System.out.println("deletion: " + ar.getAverageDeletionTime() / TestResult.VIEWRATIO);
 				System.out.println("duplicate elimination: " + ar.getAverageDuplicateEliminationTime() / TestResult.VIEWRATIO);
 				System.out.println("fill up: " + ar.getAverageFillTime() / TestResult.VIEWRATIO);
 				System.out.println("initialization: " + ar.getAverageInitTime() / TestResult.VIEWRATIO);
 				System.out.println("sort: " + ar.getAverageSortTime() / TestResult.VIEWRATIO);
 				System.out.println();
 			}
 			
 		} catch (FileNotFoundException e) {
 			System.err.println("No file to process");
 			System.exit(1);
 		} finally {
 			in.close();
 		}
    }
}
