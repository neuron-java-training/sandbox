package lists;

import java.util.ArrayList;

import tester.Test;

public class ArrayListTester extends ListTester implements Test {
	
	@Override
	public long creationTest() {
		begin = System.nanoTime();
		list = new ArrayList<>();
		end = System.nanoTime();
		return end - begin;
	}

	@Override
	public String getCollectionName() {
		return "ArrayList";
	}

}
