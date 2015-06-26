package kollekcioteszter;

import java.util.Collections;
import java.util.List;

public class ListTester extends Tester{

	private List<TestObject> list;

	public void fillTest() {
		for (int i = 0; i < super.NUMBER; i++) {
			list.add(testData[i]);
		}
	}

	public void sortTest() {
		Collections.sort(list);

	}


	public void accessTest(int elementNumber) {
		int[] indexes = new int[elementNumber];
		for (int i = 0; i < elementNumber; i++) {
			indexes[i] = (int) Math.random() * super.NUMBER;
		}
		for (int i = 0; i < elementNumber; i++) {
			list.get(indexes[i]);
		}
	}


	public void deletionTest(int first, int last) {
		for (int i = first; i <= last; i++) {
			list.remove(i);
		}

	}


	public void removeDuplicates() {
		// TODO Auto-generated method stub
		
	}

	
}
