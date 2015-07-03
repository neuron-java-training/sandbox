package hu.neuron.java.kollekcio_projekt.app;

import hu.neuron.java.kollekcio_projekt.common.TestResult;
import hu.neuron.java.kollekcio_projekt.common.TestResultAverage;

import java.util.ArrayList;
import java.util.List;

/**
 * Osztály kollekció teszteredmények átlagolásához.
 * 
 * @author Norbert
 * 
 */
public class TestResultAverageImpl implements TestResultAverage {

	/**
	 * Átlagoló metódus.
	 * 
	 * A paraméterként kapott teszteredmény listának kiszámítja az
	 * átlageredményeit, majd visszatér vele
	 * 
	 * @param eredmenyLista
	 *            a teszteredmények listáit tartalmazó lista
	 * @return A teszteredmények átlagát tartalamzó listával tér vissza, ha
	 *         vannak teszteredmények. Különben {@code null} értékkel
	 */
	@Override
	public List<TestResult> getAverage(List<List<TestResult>> eredmenyLista) {
		int HashMapTestSort = 0;
		int TreeMapTestSort = 0;
		int HashSetTestSort = 0;
		int TreeSetTestSort = 0;
		int LinkedHashSetTestSort = 0;
		int LinkedHashMapTestSort = 0;
		int ArrayDequeTestSort = 0;
		int ArrayDequeTestGet = 0;
		int LinkedHashSetTestGet = 0;
		int ArrayListTestGet = 0;
		int LinkedListDequeTestGet = 0;
		int LinkedListTestDelete = 0;
		int HashMapTestDelete = 0;
		int LinkedHashSetTestDelete = 0;
		int LinkedHashMapTestGet = 0;
		int HashSetTestGet = 0;
		int HashSetTestDelete = 0;
		int LinkedHashMapTestDelete = 0;
		int HashMapTestGet = 0;
		int TreeMapTestGet = 0;
		int TreeSetTestDelete = 0;
		int TreeMapTestDelete = 0;
		int TreeSetTestGet = 0;
		int LinkedListDequeTestInit = 0;
		int LinkedHashMapTestInit = 0;
		int ArrayListTestInit = 0;
		int HashSetTestInit = 0;
		int LinkedHashSetTestInit = 0;
		int TreeMapTestInit = 0;
		int ArrayListTestSort = 0;
		int LinkedListDequeTestSort = 0;
		int LinkedListTestSort = 0;
		int LinkedListTestInit = 0;
		int HashMapTestInit = 0;
		int TreeSetTestInit = 0;
		int ArrayDequeTestInit = 0;
		int ArrayListTestDelete = 0;
		int LinkedListTestGet = 0;
		int ArrayDequeTestDelete = 0;
		int LinkedListDequeTestDelete = 0;
		int count;

		if (eredmenyLista == null) {
			return null;
		}
		count = 0;
		for (List<TestResult> e : eredmenyLista) {
			if (e != null) {
				for (TestResult tr : e) {
					if (tr != null) {
						switch (tr.getName()) {
						case "HashMapTestSort":
							HashMapTestSort += tr.getTime();
							break;
						case "TreeMapTestSort":
							TreeMapTestSort += tr.getTime();
							break;
						case "HashSetTestSort":
							HashSetTestSort += tr.getTime();
							break;
						case "TreeSetTestSort":
							TreeSetTestSort += tr.getTime();
							break;
						case "LinkedHashSetTestSort":
							LinkedHashSetTestSort += tr.getTime();
							break;
						case "LinkedHashMapTestSort":
							LinkedHashMapTestSort += tr.getTime();
							break;
						case "ArrayDequeTestSort":
							ArrayDequeTestSort += tr.getTime();
							break;
						case "ArrayDequeTestGet":
							ArrayDequeTestGet += tr.getTime();
							break;
						case "LinkedHashSetTestGet":
							LinkedHashSetTestGet += tr.getTime();
							break;
						case "ArrayListTestGet":
							ArrayListTestGet += tr.getTime();
							break;
						case "LinkedListDequeTestGet":
							LinkedListDequeTestGet += tr.getTime();
							break;
						case "LinkedListTestDelete":
							LinkedListTestDelete += tr.getTime();
							break;
						case "HashMapTestDelete":
							HashMapTestDelete += tr.getTime();
							break;
						case "LinkedHashSetTestDelete":
							LinkedHashSetTestDelete += tr.getTime();
							break;
						case "LinkedHashMapTestGet":
							LinkedHashMapTestGet += tr.getTime();
							break;
						case "HashSetTestGet":
							HashSetTestGet += tr.getTime();
							break;
						case "HashSetTestDelete":
							HashSetTestDelete += tr.getTime();
							break;
						case "LinkedHashMapTestDelete":
							LinkedHashMapTestDelete += tr.getTime();
							break;
						case "HashMapTestGet":
							HashMapTestGet += tr.getTime();
							break;
						case "TreeMapTestGet":
							TreeMapTestGet += tr.getTime();
							break;
						case "TreeSetTestDelete":
							TreeSetTestDelete += tr.getTime();
							break;
						case "TreeMapTestDelete":
							TreeMapTestDelete += tr.getTime();
							break;
						case "TreeSetTestGet":
							TreeSetTestGet += tr.getTime();
							break;
						case "LinkedListDequeTestInit":
							LinkedListDequeTestInit += tr.getTime();
							break;
						case "LinkedHashMapTestInit":
							LinkedHashMapTestInit += tr.getTime();
							break;
						case "ArrayListTestInit":
							ArrayListTestInit += tr.getTime();
							break;
						case "HashSetTestInit":
							HashSetTestInit += tr.getTime();
							break;
						case "LinkedHashSetTestInit":
							LinkedHashSetTestInit += tr.getTime();
							break;
						case "TreeMapTestInit":
							TreeMapTestInit += tr.getTime();
							break;
						case "ArrayListTestSort":
							ArrayListTestSort += tr.getTime();
							break;
						case "LinkedListDequeTestSort":
							LinkedListDequeTestSort += tr.getTime();
							break;
						case "LinkedListTestSort":
							LinkedListTestSort += tr.getTime();
							break;
						case "LinkedListTestInit":
							LinkedListTestInit += tr.getTime();
							break;
						case "HashMapTestInit":
							HashMapTestInit += tr.getTime();
							break;
						case "TreeSetTestInit":
							TreeSetTestInit += tr.getTime();
							break;
						case "ArrayDequeTestInit":
							ArrayDequeTestInit += tr.getTime();
							break;
						case "ArrayListTestDelete":
							ArrayListTestDelete += tr.getTime();
							break;
						case "LinkedListTestGet":
							LinkedListTestGet += tr.getTime();
							break;
						case "ArrayDequeTestDelete":
							ArrayDequeTestDelete += tr.getTime();
							break;
						case "LinkedListDequeTestDelete":
							LinkedListDequeTestDelete += tr.getTime();
							break;
						}
					}
				}
				count++;
			}
		}
		List<TestResult> result = new ArrayList<>();
		result.add(new TestResult("HashMapTestSort", HashMapTestSort / count));
		result.add(new TestResult("TreeMapTestSort", TreeMapTestSort / count));
		result.add(new TestResult("HashSetTestSort", HashSetTestSort / count));
		result.add(new TestResult("TreeSetTestSort", TreeSetTestSort / count));
		result.add(new TestResult("LinkedHashSetTestSort", LinkedHashSetTestSort / count));
		result.add(new TestResult("LinkedHashMapTestSort", LinkedHashMapTestSort / count));
		result.add(new TestResult("ArrayDequeTestSort", ArrayDequeTestSort / count));
		result.add(new TestResult("ArrayDequeTestGet", ArrayDequeTestGet / count));
		result.add(new TestResult("LinkedHashSetTestGet", LinkedHashSetTestGet / count));
		result.add(new TestResult("ArrayListTestGet", ArrayListTestGet / count));
		result.add(new TestResult("LinkedListDequeTestGet", LinkedListDequeTestGet / count));
		result.add(new TestResult("LinkedListTestDelete", LinkedListTestDelete / count));
		result.add(new TestResult("HashMapTestDelete", HashMapTestDelete / count));
		result.add(new TestResult("LinkedHashSetTestDelete", LinkedHashSetTestDelete / count));
		result.add(new TestResult("LinkedHashMapTestGet", LinkedHashMapTestGet / count));
		result.add(new TestResult("HashSetTestGet", HashSetTestGet / count));
		result.add(new TestResult("HashSetTestDelete", HashSetTestDelete / count));
		result.add(new TestResult("LinkedHashMapTestDelete", LinkedHashMapTestDelete / count));
		result.add(new TestResult("TreeSetTestDelete", TreeSetTestDelete / count));
		result.add(new TestResult("TreeMapTestGet", TreeMapTestGet / count));
		result.add(new TestResult("TreeMapTestDelete", TreeMapTestDelete / count));
		result.add(new TestResult("TreeSetTestGet", TreeSetTestGet / count));
		result.add(new TestResult("LinkedListDequeTestInit", LinkedListDequeTestInit / count));
		result.add(new TestResult("LinkedHashMapTestInit", LinkedHashMapTestInit / count));
		result.add(new TestResult("ArrayListTestInit", ArrayListTestInit / count));
		result.add(new TestResult("HashSetTestInit", HashSetTestInit / count));
		result.add(new TestResult("LinkedHashSetTestInit", LinkedHashSetTestInit / count));
		result.add(new TestResult("TreeMapTestInit", TreeMapTestInit / count));
		result.add(new TestResult("ArrayListTestSort", ArrayListTestSort / count));
		result.add(new TestResult("LinkedListDequeTestSort", LinkedListDequeTestSort / count));
		result.add(new TestResult("LinkedListTestSort", LinkedListTestSort / count));
		result.add(new TestResult("LinkedListTestInit", LinkedListTestInit / count));
		result.add(new TestResult("HashMapTestInit", HashMapTestInit / count));
		result.add(new TestResult("TreeSetTestInit", TreeSetTestInit / count));
		result.add(new TestResult("ArrayDequeTestInit", ArrayDequeTestInit / count));
		result.add(new TestResult("ArrayListTestDelete", ArrayListTestDelete / count));
		result.add(new TestResult("LinkedListTestGet", LinkedListTestGet / count));
		result.add(new TestResult("ArrayDequeTestDelete", ArrayDequeTestDelete / count));
		result.add(new TestResult("HashMapTestGet", HashMapTestGet / count));
		result.add(new TestResult("LinkedListDequeTestDelete", LinkedListDequeTestDelete / count));
		return result;
	}

}
