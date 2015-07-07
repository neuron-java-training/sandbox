package hu.neuron.java.project.app;

import hu.neuron.java.project.app.tester.GenericTestRunner;
import hu.neuron.java.project.common.interfaces.Reader;
import hu.neuron.java.project.core.FileProcessor;

/**
 * Hello Collections!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        GenericTestRunner runner = new GenericTestRunner();
		runner.runTests();
        Reader reader = new FileProcessor();
        reader.read();
    }
}
