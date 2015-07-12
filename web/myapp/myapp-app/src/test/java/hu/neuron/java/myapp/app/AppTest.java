package hu.neuron.java.myapp.app;

import hu.neuron.java.myapp.core.IO;
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
    }
    
    public void test(){
    	TestRunner testrunner = new TestRunner();
		IO io = new IO();

		Tester.doListTest();
		Tester.doSetTest();
		Tester.doQueueTest();
		Tester.doDequeTest();

		testrunner.order();

		io.write(TestRunner.getTestresults());

		System.out.println(TestRunner.INITNUMBER + " variable "
				+ "average init() time, with:\n");
		
		io.read();
    }
    
    
}
