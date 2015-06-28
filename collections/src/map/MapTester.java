package map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

import tester.TestObject;
import tester.Tester;


public class MapTester extends Tester{
	
	Random random = new Random();

	protected Map<TestObject,TestObject> map;
	private ArrayList<TestObject> duplicates;
	protected long begin, end;

	public long fillTest() {
		begin = System.nanoTime();
		for (int i = 0; i < NUMBER; i++) {
			map.put(testData[i],testData[i]);
		}
		end = System.nanoTime();
		return end - begin;
	}

	public long sortTest() {
		begin = System.nanoTime();
		ArrayList<TestObject> sortedElements = new ArrayList<>(map.size());
		sortedElements.addAll(map.values());
		Collections.sort(sortedElements);
		end = System.nanoTime();
		return end - begin;
	}

	public long accessTest(int elementNumber) {
		ArrayList<TestObject> selectedElements = selectElements(elementNumber);
		begin = System.nanoTime();
		for(TestObject to : selectedElements){
			map.containsKey(to);
		}
		end = System.nanoTime();
		return end - begin;
	}

	public long deletionTest(int first, int last) {
		ArrayList<TestObject> selectedElements = selectElements(last-first);
		begin = System.nanoTime();
		for(TestObject to : selectedElements){
			map.remove(to);
		}
		end = System.nanoTime();
		return end - begin;
	}

	public long removeDuplicates() {
		duplicates = collectDuplicates();
		begin = System.nanoTime();
		for(TestObject to : duplicates){
			map.remove(to);
		};
		end = System.nanoTime();
		return end - begin;
	}
	
	private ArrayList<TestObject> selectElements(int elementNumber){
		ArrayList<TestObject> elements = new ArrayList<>(elementNumber);
		LinkedList<TestObject> tmp = new LinkedList<>();
		for(TestObject to : map.keySet()){
			tmp.addLast(to);
		}
		int selected = 0;
		if(tmp.size() <= elementNumber)
			//TreeMap esetében, volt hogy kevesebb eleme volt alapból mint ez a szám
			//gondolom mert nem adta hozzá a duplikált elemeket
			elementNumber = tmp.size() / 2;	
		while( selected < elementNumber){	
			for(int i = 0; i < tmp.size() && selected < elementNumber; i++){	
				if(random.nextInt(100) % 3 == 0){
					elements.add(tmp.remove(i));
					++selected;
				}
			}
		}
		return elements;
	}

	private ArrayList<TestObject> collectDuplicates(){
		ArrayList<TestObject> tmp = new ArrayList<>((int)((NUMBER/10)*9));
		ArrayList<TestObject> duplicates = new ArrayList<>((int)((NUMBER/10)));
		for(TestObject to : map.values()){
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
