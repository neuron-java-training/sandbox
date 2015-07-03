package hu.neuron.java.project.app.tester;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class IndexlessBasicTest extends BasicTest {
	
	Random random = new Random();

	protected ArrayList<TestObject> selectElements(int elementNumber, Collection<TestObject> collection){
		ArrayList<TestObject> elements = new ArrayList<>(elementNumber);
		LinkedList<TestObject> tmp = new LinkedList<>(collection);
		tmp.addAll(collection);	
		int selected = 0;
		while( selected < elementNumber){
			Iterator<TestObject> iter = tmp.iterator();
			while(iter.hasNext() && selected < elementNumber){
				if(random.nextInt(100) % 3 == 0){
					TestObject to = iter.next();
					elements.add(to);
					iter.remove();
					selected++;
				}
			}
		}
		return elements;
	}
	
}
