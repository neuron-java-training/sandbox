package hu.neuron.java.project.app;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class RunnerTest {


	@Test
	public void test1() {
		TestRunner.add();
		TestRunner.run();
		TestRunner.IO();
	}

}
