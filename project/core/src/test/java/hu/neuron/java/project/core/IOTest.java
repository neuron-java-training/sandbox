package hu.neuron.java.project.core;

import java.util.ArrayList;

import org.junit.Test;

public class IOTest {

	

	@Test
	public void test1() {
		IO io = new IO();
		io.write(new ArrayList<>());
	}

	@Test
	public void test2() {
		IO io = new IO();
		io.read();
	}
}
