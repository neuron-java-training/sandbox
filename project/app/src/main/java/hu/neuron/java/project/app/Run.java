package hu.neuron.java.project.app;

import hu.neuron.java.project.core.IO;
import hu.neuron.java.project.core.TestingResults;

import java.util.ArrayList;
import java.util.List;

import hu.neuron.java.project.app.*;
@SuppressWarnings("unused")
public class Run {
	List<Test> myList;
	List<TestingResults> myList2 = new ArrayList<TestingResults>();

	public Run() {

		this.myList = new ArrayList<Test>();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Run myRun = new Run();
		myRun.test();
		IO myIO = new IO(myRun.myList2);
		//myIO.read("valami.txt", myRun.myList2);
		myIO.write("valami2.txt" );
	}

	private void test() {
		// TODO Auto-generated method stub

		myList.add(new ArrayListTest());

		for (Test test : this.myList) {
			TestingResults name = new TestingResults();
			name.setCollectionName(test.getCollectionName());
			name.setInitTime(test.init());
			name.setDeleteTime(test.delete(1, 2));
			name.setSortTime(test.sort());
			name.setGetTime(test.get(300));
			myList2.add(name);
		}
		
		for (TestingResults myResult : myList2) {
			System.out.println(myResult);
		}
	}

}
