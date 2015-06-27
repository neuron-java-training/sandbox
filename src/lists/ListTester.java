package lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import kollekcioteszter.TestObject;
import kollekcioteszter.Tester;

public class ListTester extends Tester{

	List<TestObject> list;
	private List<TestObject> duplicates;
	private int[] indexes;
	protected long begin, end;

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
		ArrayList<TestObject> duplicates = new ArrayList<>((int)((NUMBER/10)));
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
}
