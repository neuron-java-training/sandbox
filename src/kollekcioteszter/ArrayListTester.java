package kollekcioteszter;

import java.util.ArrayList;

public class ArrayListTester extends ListTester implements Test {
	
	@SuppressWarnings("unused")
	private ArrayList<TestObject> list;
	
	@Override
	public void creationTest() {
		list = new ArrayList<>();
	}

}
