package kollekcioteszter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IndexlessTester extends Tester {

	protected ArrayList<TestObject> selectElements(int elementNumber, Collection<TestObject> collection){
		ArrayList<TestObject> elements = new ArrayList<>(elementNumber);
		int selected = 0;
		while( selected != elementNumber){
			Iterator<TestObject> setIter = collection.iterator();
			while(setIter.hasNext() && selected != elementNumber ){
				if((int)(Math.random()*100)%3 == 0){
					TestObject to = setIter.next();
					elements.add(to);
					setIter.remove();
					selected++;
				}
			}
		}
		return elements;
	}
	
}
