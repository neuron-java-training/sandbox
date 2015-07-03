package hu.neuron.java.project.app.queue;

import hu.neuron.java.project.app.tester.IndexlessBasicTest;
import hu.neuron.java.project.app.tester.Test;
import hu.neuron.java.project.app.tester.TestObject;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueTester extends IndexlessBasicTest implements Test {
	
	private PriorityQueue<TestObject> queue;
	private List<TestObject> duplicates;
	private long begin, end;

	@Override
	public long creationTest() {
		begin = System.nanoTime();
		queue = new PriorityQueue<>();
		end = System.nanoTime();
		return end - begin;
	}

	@Override
	public long fillTest() {
		begin = System.nanoTime();
		for (int i = 0; i < NUMBER; i++) {
			queue.add(testData[i]);
		}
		end = System.nanoTime();
		return end - begin;
	}

	@Override
	public long sortTest() {
		begin = System.nanoTime();
		end = System.nanoTime();
		return end - begin;
	}

	@Override
	public long accessTest(int elementNumber) {
		ArrayList<TestObject> selectedElements = selectElements(elementNumber,queue);
		begin = System.nanoTime();
		for(TestObject to : selectedElements){
			queue.contains(to);
		}
		end = System.nanoTime();
		return end - begin;
	}

	@Override
	public long deletionTest(int first, int last) {
		ArrayList<TestObject> selectedElements = selectElements(last-first,queue);
		begin = System.nanoTime();
		queue.removeAll(selectedElements);
		end = System.nanoTime();
		return end - begin;
	}

	@Override
	public long removeDuplicates() {
		duplicates = collectDuplicates();
		begin = System.nanoTime();
		queue.removeAll(duplicates);
		end = System.nanoTime();
		return end - begin;
	}

	@Override
	public String getCollectionName() {
		return "PriorityQueue";
	}
	
	private ArrayList<TestObject> collectDuplicates(){
		ArrayList<TestObject> tmp = new ArrayList<>((int)((NUMBER/10)*9));
		ArrayList<TestObject> duplicates = new ArrayList<>((int)((NUMBER/10)));
		for(TestObject to : queue){
			if(!tmp.contains(to)){
				tmp.add(to);
			}
			else{
				duplicates.add(to);
			}
		 }
		return  duplicates;
	}
}
