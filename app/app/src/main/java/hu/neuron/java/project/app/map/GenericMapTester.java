package hu.neuron.java.project.app.map;

import hu.neuron.java.project.app.tester.Test;
import hu.neuron.java.project.app.tester.TestObject;
import hu.neuron.java.project.app.tester.BasicTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;


public class GenericMapTester<T extends Map<TestObject,TestObject>> extends BasicTest implements Test{
	
	protected T map;
	Random random = new Random();
	private ArrayList<TestObject> duplicates;
	protected long begin, end;
	private long creation;
	
	public GenericMapTester(T t){
		map = t;
	}

	public long fillTest() {
		begin = System.nanoTime();
		for (int i = 0; i < NUMBER; i++) {
			map.put(testData[i],testData[i]);
		}
		end = System.nanoTime();
		return end - begin;
	}

	public long sortTest() {
		if(map instanceof TreeMap)
			return 0;
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
			//TreeMap eset�ben, volt hogy kevesebb eleme volt alapb�l mint ez a sz�m
			//gondolom mert nem adta hozz� a duplik�lt elemeket
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

	@Override
	public long creationTest() {
		return creation;
	}

	@Override
	public String getCollectionName() {
		return map.getClass().getName();
	}
	
	public void setCreationTime(long time){
		creation = time;
	}
}
