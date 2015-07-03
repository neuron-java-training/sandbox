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
		for(int i = 0; i < 5; i++){
			runner.runTests();
		}
        Reader reader = new FileProcessor();
        reader.read();
    }
}
