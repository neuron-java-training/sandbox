package hu.neuron.java.servlet;

import java.util.ArrayList;
import java.util.List;

import hu.neuron.java.myapp.app.Main;
import hu.neuron.java.myapp.app.TestResults;
import hu.neuron.java.myapp.app.TestRunner;


public class ButtonActions {
	public static List<?> buttonAction() {
		TestRunner.setTestresults(new ArrayList<TestResults>());
		
		List<TestResults> list = new ArrayList<>();

		list = Main.main();
		
		return list;
		
	}
}
