package hu.neuron.java.project.app.lists;

import static org.junit.Assert.*;
import hu.neuron.java.project.core.TestResult;

import org.junit.BeforeClass;
import org.junit.Test;

public class ArrayListTesterTest {
	
	private static ArrayListTester test;
	private static TestResult result;
	
	@BeforeClass
	public static void setUpBeforeClass(){
		test = new ArrayListTester();
		result = new TestResult(test.getCollectionName());
		test.creationTest();
		test.fillTest();
	}

	@Test
	public void testerInstatiationTest() {
		assertNotNull("Object couldn't been initilaized",test);
	}
	
	@Test
	public void getNameTest(){
		assertNotNull("No name",test.getCollectionName());
	}
	
	@Test
	public void initTimeTest(){
		result.setInitTime(test.creationTest());
		assertTrue(result.getInitTime() > 0);
	}
	
	@Test
	public void fillTimeTest(){
		result.setFillTime(test.fillTest());
		assertTrue(result.getFillTime() > 0);
	}
	
	@Test
	public void sortTimeTest(){
		result.setSortTime(test.sortTest());
		assertTrue(result.getSortTime() > 0);
	}
	
	@Test
	public void accessTimeTest(){
		result.setAccessTime(test.accessTest(3000));
		assertTrue(result.getAccessTime() > 0);
	}
	
	@Test
	public void deletionTimeTest(){
		result.setDeletionTime(test.deletionTest(2500, 3900));
		assertTrue(result.getDeletionTime() > 0);
	}
	
	@Test
	public void duplicateEliminationTimeTest(){
		result.setDuplicateEliminationTime(test.removeDuplicates());
		assertTrue(result.getDuplicateEliminationTime() > 0);
	}
	

}
