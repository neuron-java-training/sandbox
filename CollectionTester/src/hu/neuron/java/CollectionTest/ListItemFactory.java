package hu.neuron.java.CollectionTest;

import java.util.Random;

public class ListItemFactory {

	private static final int MAX_OF_RANDOM_ID = 2000;
	private static final int LENGTH_OF_VALUE = 4;

	public ListItem getRandomListItem() {
		return new ListItem(randomInt(MAX_OF_RANDOM_ID), randomString(LENGTH_OF_VALUE));
	}

	private int randomInt(int max) {
		Random rand = new Random();
		return rand.nextInt(max);
	}
	
	private String randomString(int length){
		String result = "";
		for (int i = 0; i < length; i++) {
			result += (char)(randomInt(25)+65);
		}
		
		return result;
	}	
}
