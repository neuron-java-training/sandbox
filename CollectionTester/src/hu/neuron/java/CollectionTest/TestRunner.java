package hu.neuron.java.CollectionTest;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestRunner {

	
	private List<Tester> testList = null;
	private List<TestResult> resultList = null;

	public TestRunner() {
		super();
		this.testList = new ArrayList<>();
		this.resultList = new ArrayList<>();
	}

	public void addTest(Tester tester){
		this.testList.add(tester);
	}
	
	public List<TestResult> runAllTest(){
		resultList.clear();
		
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		
		for (Tester tester : testList) {
			Future<TestResult> future = executorService.submit(new TestRunnerThread(tester));
			try {
				resultList.add(future.get());
			} catch (Exception e) {
			} 
		}
		
		executorService.shutdown();
		return resultList;
	}

	public void writeResultsToFile(String fileName) {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "utf-8"))) {
			writer.write(this.toString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		String result = "";
		for (TestResult r : resultList) {
			result += r + "\n";
		}
		return result;
	}
}
