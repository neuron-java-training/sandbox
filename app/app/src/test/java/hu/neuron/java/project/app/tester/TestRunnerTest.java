package hu.neuron.java.project.app.tester;

import static org.junit.Assert.*;
import hu.neuron.java.project.app.App;

import org.junit.Test;

public class TestRunnerTest {

	@Test
	public void testRunnerInstantiation() {
		assertNotNull("Object couldn't been initilaized",new TestRunner());
	}
}
