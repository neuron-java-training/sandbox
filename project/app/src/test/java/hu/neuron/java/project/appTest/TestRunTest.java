package hu.neuron.java.project.appTest;

import hu.neuron.java.project.app.TestRun;

import org.junit.Test;

public class TestRunTest {

	@Test
	public void test1() {
		TestRun tr = new TestRun();
		tr.test();

	}
	
	@Test
	public void test2(){
		TestRun tr=new TestRun();
		tr.testStaticCollections();
	}

}
