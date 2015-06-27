package lists;

import java.util.LinkedList;

import kollekcioteszter.Test;

public class LinkedListTester extends ListTester implements Test {

	@Override
	public long creationTest() {
		begin = System.nanoTime();
		list = new LinkedList<>();
		end = System.nanoTime();
		return end - begin;
	}

	@Override
	public String getCollectionName() {
		
		return "LinkedList";
	}

}
