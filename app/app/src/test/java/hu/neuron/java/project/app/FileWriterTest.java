package hu.neuron.java.project.app;

import hu.neuron.java.project.app.dequeue.ArrayDequeTester;
import hu.neuron.java.project.app.lists.ArrayListTester;
import hu.neuron.java.project.app.lists.LinkedListTester;
import hu.neuron.java.project.app.map.HashMapTester;
import hu.neuron.java.project.app.map.LinkedHashMapTester;
import hu.neuron.java.project.app.map.TreeMapTester;
import hu.neuron.java.project.app.queue.PriorityQueueTester;
import hu.neuron.java.project.app.sets.HashSetTester;
import hu.neuron.java.project.app.sets.LinkedHashSetTester;
import hu.neuron.java.project.app.sets.TreeSetTester;
import hu.neuron.java.project.core.FileWriter;
import hu.neuron.java.project.core.TestResult;

import java.util.ArrayList;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class FileWriterTest {
	
    private static ArrayList<TestResult> results = new ArrayList<>();
	
	@BeforeClass
	public static void setUpBeforeClass(){

			ArrayList<hu.neuron.java.project.app.tester.Test> tests = new ArrayList<>();
			tests.add(new ArrayListTester());
			tests.add(new LinkedListTester());
			tests.add(new HashSetTester());
			tests.add(new TreeSetTester());
			tests.add(new LinkedHashSetTester());
			tests.add(new PriorityQueueTester());
			tests.add(new ArrayDequeTester());
			tests.add(new HashMapTester());
			tests.add(new TreeMapTester());
			tests.add(new LinkedHashMapTester());

			for (hu.neuron.java.project.app.tester.Test t : tests) {
				TestResult tr = new TestResult(t.getCollectionName());
				
				tr.setInitTime(t.creationTest());
				tr.setFillTime(t.fillTest());
				tr.setSortTime(t.sortTest());
				tr.setAccessTime(t.accessTest(3000));
				tr.setDeletionTime(t.deletionTest(2500, 3900));
				tr.setDuplicateEliminationTime(t.removeDuplicates());

				results.add(tr);
			}	
	}

	@Test
	public void testWrite() {
		FileWriter writer = new FileWriter(results,"test-results.txt");
		writer.write();
	}

}
