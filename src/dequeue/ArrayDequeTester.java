package dequeue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kollekcioteszter.IndexlessTester;
import kollekcioteszter.Test;
import kollekcioteszter.TestObject;

public class ArrayDequeTester extends IndexlessTester implements Test {
	
	private ArrayDeque<TestObject> deque;
	private List<TestObject> duplicates;
	long begin, end;

	@Override
	public long creationTest() {
		begin = System.nanoTime();
		deque = new ArrayDeque<>();
		end = System.nanoTime();
		return end - begin;
	}

	@Override
	public long fillTest() {
		begin = System.nanoTime();
		for (int i = 0; i < NUMBER; i++) {
			deque.add(testData[i]);
		}
		end = System.nanoTime();
		return end - begin;
	}

	@Override
	public long sortTest() {
		begin = System.nanoTime();
		TestObject[] tmp = deque.toArray(new TestObject[0]);
		deque.clear();
		Arrays.sort(tmp);
		deque.addAll(Arrays.asList(tmp));
		end = System.nanoTime();
		return end - begin;
	}

	@Override
	public long accessTest(int elementNumber) {
		ArrayList<TestObject> selectedElements = selectElements(elementNumber,deque);
		begin = System.nanoTime();
		for(TestObject to : selectedElements){
			deque.contains(to);
		}
		end = System.nanoTime();
		return end - begin;
	}

	@Override
	public long deletionTest(int first, int last) {
		ArrayList<TestObject> selectedElements = selectElements(last-first,deque);
		begin = System.nanoTime();
		deque.removeAll(selectedElements);
		end = System.nanoTime();
		return end - begin;
	}

	@Override
	public long removeDuplicates() {
		duplicates = collectDuplicates();
		begin = System.nanoTime();
		deque.removeAll(duplicates);
		end = System.nanoTime();
		return end - begin;
	}

	@Override
	public String getCollectionName() {
		
		return "ArrayDeque";
	}
	
	private ArrayList<TestObject> collectDuplicates(){
		ArrayList<TestObject> tmp = new ArrayList<>((int)((NUMBER/10)*9));
		ArrayList<TestObject> duplicates = new ArrayList<>((int)((NUMBER/10)));
		for(TestObject to : deque){
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
