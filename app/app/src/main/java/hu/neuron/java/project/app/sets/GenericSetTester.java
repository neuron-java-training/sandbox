package hu.neuron.java.project.app.sets;

import hu.neuron.java.project.app.tester.IndexlessBasicTest;
import hu.neuron.java.project.app.tester.Test;
import hu.neuron.java.project.app.tester.TestObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class GenericSetTester<T extends Set<TestObject>> extends IndexlessBasicTest implements Test{

	protected T set;
	protected List<TestObject> duplicates;
	protected long begin, end;
	private long creation;
	
	public GenericSetTester(T t){
		set = t;
	}

	public long fillTest() {
		begin = System.nanoTime();
		for (int i = 0; i < NUMBER; i++) {
			set.add(testData[i]);
		}
		end = System.nanoTime();
		return end - begin;
	}

	public long accessTest(int elementNumber) {
		ArrayList<TestObject> selectedElements = selectElements(elementNumber,set);
		begin = System.nanoTime();
		for(TestObject to : selectedElements){
			set.contains(to);
		}
		end = System.nanoTime();
		return end - begin;
	}

	public long deletionTest(int first, int last) {
		ArrayList<TestObject> selectedElements = selectElements(last-first, set);
		begin = System.nanoTime();
		set.removeAll(selectedElements);
		end = System.nanoTime();
		return end - begin;
	}

	public long removeDuplicates() {
		return 0;
	}

	@Override
	public long sortTest() {
		if(set instanceof TreeSet)
			return 0;
		begin = System.nanoTime();
		@SuppressWarnings("unused")
		TreeSet<TestObject> ts = new TreeSet<>(set);
		end = System.nanoTime();
		return end - begin;
	}
	@Override
	public long creationTest() {
		return creation;
	}

	@Override
	public String getCollectionName() {
		return set.getClass().getName();
	}
	
	public void setCreationTime(long time){
		creation = time;
	}
}
