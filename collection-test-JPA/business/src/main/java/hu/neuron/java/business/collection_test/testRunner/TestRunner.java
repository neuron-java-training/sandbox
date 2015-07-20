package hu.neuron.java.business.collection_test.testRunner;

import hu.neuron.java.business_api.collection_test.TestRunnerInterface;
import hu.neuron.java.business_api.collection_test.Tester;
import hu.neuron.java.service.vo.ResultVO;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestRunner implements TestRunnerInterface{

	private List<Tester> testList = null;
	private List<ResultVO> resultList = null;

	public TestRunner() {
		super();
		this.testList = new ArrayList<>();
		this.resultList = new ArrayList<>();
	}

	@Override
	public void addTest(Tester tester){
		this.testList.add(tester);
	}
	
	@Override
	public List<ResultVO> runAllTest(){
		resultList.clear();
		
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		
		for (Tester tester : testList) {
			Future<ResultVO> future = executorService.submit(new TestRunnerThread(tester));
			try {
				resultList.add(future.get());
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
		executorService.shutdown();
		return resultList;
	}

	@Override
	public List<ResultVO> getResultList() {
		return resultList;
	}
	
	@Override
	public String toString() {
		String result = "";
		for (ResultVO r : resultList) {
			result += r + "\n";
		}
		return result;
	}	
	
}
