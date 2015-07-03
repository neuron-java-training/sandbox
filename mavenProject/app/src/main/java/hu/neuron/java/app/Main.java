package hu.neuron.java.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		long sumInit = 0;
		long sumSort = 0;
		long sumGet = 0;
		long sumDel = 0;
		long sumInitl = 0;
		long sumSortl = 0;
		long sumGetl = 0;
		long sumDell = 0;
		
		TestRunner runner2 = new TestRunner();
		TestRunner runner = new TestRunner();
		
		
		runner.run();
		File file = new File("ArrayTest.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		Scanner sc = new Scanner(file);
		for (int i = 0; i < runner.getNumberOfTests(); i++) {
			
			sumInit += sc.nextInt(); sc.nextLine();
			sumSort += sc.nextInt(); sc.nextLine();
			sumGet += sc.nextInt(); sc.nextLine();
			sumDel += sc.nextInt(); sc.nextLine();	
		}
		int t = runner.getNumberOfTests();
		System.out.println("ArrayAvrages : "+sumInit/t + "  "+sumSort/t+ "  "+sumGet/t+"  "+sumDel/t);
		fr.close();
		br.close();
		sc.close();
		
		File file1 = new File("LinkedTest.txt");
		FileReader fr1 = new FileReader(file1);
		BufferedReader br1 = new BufferedReader(fr1);
		Scanner sc1 = new Scanner(file1);
		for (int i = 0; i < runner.getNumberOfTests(); i++) {
			
			sumInitl += sc1.nextInt(); sc1.nextLine();
			sumSortl += sc1.nextInt(); sc1.nextLine();
			sumGetl += sc1.nextInt(); sc1.nextLine();
			sumDell += sc1.nextInt(); sc1.nextLine();	
		}
		int t1 = runner.getNumberOfTests();
		System.out.println("LinkedAvrages : "+sumInitl/t1 + "  "+sumSortl/t1+ "  "+sumGetl/t1+"  "+sumDell/t1);
		fr1.close();
		br1.close();
		sc1.close();
		


	}

		
		
		
}
