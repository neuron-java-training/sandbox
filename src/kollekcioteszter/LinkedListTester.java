package kollekcioteszter;

import java.util.LinkedList;

public class LinkedListTester extends ListTester implements Test {

	@SuppressWarnings("unused")
	private LinkedList<TestObject> list;

	@Override
	public void creationTest() {
		list = new LinkedList<>();
	}

}
