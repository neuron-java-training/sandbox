package hu.neuron.java.project.app;

import hu.neuron.java.project.app.App;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class AppTest 
    extends TestCase
{

    public AppTest( String testName )
    {
        super( testName );
    }


    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

	public void testAppInstantiation() {
		assertNotNull("Object couldn't been initilaized",new App());
	}

}
