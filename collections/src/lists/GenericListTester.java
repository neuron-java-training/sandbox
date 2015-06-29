package lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tester.Test;
import tester.TestObject;
import tester.Tester;

public class GenericListTester<T extends List<TestObject>> extends Tester implements Test{

	T list;
	private List<TestObject> duplicates;
	private int[] indexes;
	protected long begin, end;
	private long creation;
	
	public GenericListTester(T t){
		list = t;
	}

	public long fillTest() {
		begin = System.nanoTime();
		for (int i = 0; i < NUMBER; i++) {
			list.add(testData[i]);
		}
		end = System.nanoTime();
		return end - begin;
	}

	public long sortTest() {
		begin = System.nanoTime();
		Collections.sort(list);
		end = System.nanoTime();
		return end - begin;
	}

	public long accessTest(int elementNumber) {
		createIndexes(elementNumber);
		begin = System.nanoTime();
		for (int i = 0; i < elementNumber; i++) {
			list.get(indexes[i]);
		}
		end = System.nanoTime();
		return end - begin;
	}

	public long deletionTest(int first, int last) {
		begin = System.nanoTime();
		for (int i = first; i <= last; i++) {
			list.remove(i);
		}
		end = System.nanoTime();
		return end - begin;
	}

	public long removeDuplicates() {
		duplicates = collectDuplicates();
		begin = System.nanoTime();
		list.removeAll(duplicates);
		end = System.nanoTime();
		return end - begin;
	}
	
	protected void createIndexes(int elementNumber){
		indexes = new int[elementNumber];
		for (int i = 0; i < elementNumber; i++) {
			indexes[i] = (int) (Math.random() * NUMBER);
		}
	}
	
	private ArrayList<TestObject> collectDuplicates(){
		ArrayList<TestObject> tmp = new ArrayList<>((int)((NUMBER/10)*9));
		ArrayList<TestObject> duplicates = new ArrayList<>((int)(NUMBER/10));
		for(TestObject to : list){
			if(!tmp.contains(to)){
				tmp.add(to);
			}
			else{
				duplicates.add(to);
			}
		 }
		return  duplicates;
	}

	@Override
	public long creationTest() {
		return creation;
	}

	@Override
	public String getCollectionName() {
		return list.getClass().getName();
	}
	
	public void setCreationTime(long time){
		creation = time;
	}
}
