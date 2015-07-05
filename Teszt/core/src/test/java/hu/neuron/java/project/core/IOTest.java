package hu.neuron.java.project.core;

import org.junit.Test;

public class IOTest {
	


	@Test
	public void test1() {
		IO io = new IO();
		io.write("java.util.ArrayList, 2, 0, 324, 320");
//		Result res  = new Result();
//		res.setDelete(320);
//		res.setGetElement(324);
//		res.setInit(2);
//		res.setName("java.util.ArrayList");
//		res.setSort(0);
		
		io.write("java.util.ArrayList, 1, 31, 123, 313");
//		
//		res.setDelete(320);
//		res.setGetElement(324);
//		res.setInit(2);
//		res.setName("java.util.ArrayList");
//		res.setSort(0);
//		io.write(res.toString());
	}

	
	@Test
	public void test2() {
		IO io = new IO();
		io.read();
	}

	

}
