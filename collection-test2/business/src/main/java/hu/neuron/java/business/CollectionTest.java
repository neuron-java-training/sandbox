package hu.neuron.java.business;

import hu.neuron.java.business.collection_test.list_test.ArrayListTester;
import hu.neuron.java.business.collection_test.list_test.LinkedListTester;
import hu.neuron.java.business.collection_test.set_test.HashSetTester;
import hu.neuron.java.business.collection_test.set_test.LinkedHashSetTester;
import hu.neuron.java.business.collection_test.set_test.TreeSetTester;
import hu.neuron.java.business.collection_test.testRunner.TestRunner;
import hu.neuron.java.business_api.collection_test.CollectionTesterInterface;
import hu.neuron.java.business_api.collection_test.TestResult;
import hu.neuron.java.persistence.test_result.TestResultDAOInterface;
import hu.neuron.java.persistence.test_result.TestResultDTO;

import java.util.ArrayList;
import java.util.List;

import persistence.test_result.dao.TestResultDAO;

public class CollectionTest implements CollectionTesterInterface{

	public CollectionTest() {
		
	}
	
	public List<TestResult> run(int initSize, int testSize){
		TestRunner testRunner = new TestRunner();
		testRunner.addTest(new ArrayListTester(initSize, testSize));
		testRunner.addTest(new LinkedListTester(initSize, testSize));
		testRunner.addTest(new TreeSetTester(initSize, testSize));
		testRunner.addTest(new LinkedHashSetTester(initSize, testSize));
		testRunner.addTest(new HashSetTester(initSize, testSize));
		testRunner.runAllTest();
		
		List<TestResult> resultList = testRunner.getResultList();
		
		TestResultDAOInterface dao = new TestResultDAO();
		for (TestResult testResult : resultList) {
			try {
				dao.save(Mapper.TestResultToTestResultDTO(testResult));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return resultList;
	}

	@Override
	public List<TestResult> getAverageOfResult() {
		
		TestResultDAOInterface dao = new TestResultDAO();
		List<TestResult> results = new ArrayList<>();
		List<TestResultDTO> resultsOfDAO = new ArrayList<>();
		
		try {
			resultsOfDAO = dao.getAverages();
			for (TestResultDTO dto : resultsOfDAO) {
				results.add(Mapper.TestResultDTOToTestResult(dto));
			}
			return results;
		} catch (Exception e) {
			return new ArrayList<>();
		}
		
		
	}
}
