package hu.neuron.java.project.core;

import hu.neuron.java.project.common.Result;

import org.junit.Test;





public class IOTest {

	@Test
	public void test1() {
		IO io = new IO();
		Result res  = new Result();
		res.setDelete(320);
		res.setGetElement(324);
		res.setInit(2);
		res.setName("Arraylist");
		res.setSort(0);
		
		io.write(res);
		
		res.setDelete(320);
		res.setGetElement(324);
		res.setInit(2);
		res.setName("Arraylist");
		res.setSort(0);
		io.write(res);
	}

	
	@Test
	public void test2() {
		IO io = new IO();
		io.read();
	}

	

}
