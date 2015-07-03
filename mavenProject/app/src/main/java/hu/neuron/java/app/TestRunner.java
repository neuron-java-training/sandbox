package hu.neuron.java.app;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;

public class TestRunner {
	private int numberOfTests = 0;
	
	public int getNumberOfTests() {
		return numberOfTests;
	}


	
	public void testArray(){
		
		ArrayList<ComparableItem> array = new ArrayList<ComparableItem>();
		Tester test = new Tester(array);
		
		
		File farray = new File("ArrayTest.txt");
		
		
		FileWriter fw;
		try {
			fw = new FileWriter(farray,true);
			PrintWriter bw = new PrintWriter(fw);
			bw.print(test.init()); 
			bw.println();
			bw.print(test.sort()); 
			bw.println();
			bw.print(test.getRand(5000));
			bw.println();
			bw.print(test.delete(100,1000));
			bw.println();
			
			
				
			
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
public void testLinked(){
		
		LinkedList<ComparableItem> linked = new LinkedList<ComparableItem>();
		Tester test = new Tester(linked);
		
		
		File larray = new File("LinkedTest.txt");
		
		
		FileWriter fw;
		try {
			fw = new FileWriter(larray,true);
			PrintWriter bw = new PrintWriter(fw);
			bw.print(test.init()); 
			bw.println();
			bw.print(test.sort()); 
			bw.println();
			bw.print(test.getRand(5000));
			bw.println();
			bw.print(test.delete(100,1000));
			bw.println();
			
			
				
			
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public void run(){
		numberOfTests++;
		testArray();
		
		System.out.println("finished running(array)");
		testLinked();
		System.out.println("finished running(linked)");
	}

}
