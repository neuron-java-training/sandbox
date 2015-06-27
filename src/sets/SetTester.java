package sets;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import kollekcioteszter.IndexlessTester;
import kollekcioteszter.TestObject;

public class SetTester extends IndexlessTester {

	protected Set<TestObject> set;
	protected List<TestObject> duplicates;
	protected long begin, end;

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
}
