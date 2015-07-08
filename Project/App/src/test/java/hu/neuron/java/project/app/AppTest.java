package hu.neuron.java.project.app;

import hu.neuron.java.project.core.TestArrayList;
import hu.neuron.java.project.core.TestLinkedList;
import hu.neuron.java.project.core.TestTreeSet;

import java.io.File;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
        
        boolean fileCheck = true;
		int fileCounter = 0;

		while (fileCheck) {
			if (!new File("test" + fileCounter + "result.txt").isFile()) {
				fileCheck = false;
			} else {
				fileCounter++;
			}
		}

		TestLinkedList listTest = new TestLinkedList();
		TestThread<TestLinkedList> listTestRunnable = new TestThread<TestLinkedList>(listTest,
				"listTest", fileCounter);
		Thread listTestThread = new Thread(listTestRunnable);

		TestArrayList arrayTest = new TestArrayList();
		TestThread<TestArrayList> arrayTestRunnable = new TestThread<TestArrayList>(arrayTest,
				"arrayTest", fileCounter);
		Thread arrayTestThread = new Thread(arrayTestRunnable);

		TestTreeSet treeTest = new TestTreeSet();
		TestThread<TestTreeSet> treeTestRunnable = new TestThread<TestTreeSet>(treeTest,
				"treeTest", fileCounter);
		Thread treeTestThread = new Thread(treeTestRunnable);

		listTestThread.start();
		arrayTestThread.start();
		treeTestThread.start();

		while (listTestThread.isAlive() || arrayTestThread.isAlive() || treeTestThread.isAlive()) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        
        
    }
}
