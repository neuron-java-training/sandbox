package hu.neuron.java.business;

import hu.neuron.java.business_api.collection_test.TestResult;
import hu.neuron.java.persistence.test_result.TestResultDTO;

public class Mapper {

	public static TestResult TestResultDTOToTestResult(TestResultDTO dto) {
		TestResult result =  new TestResult();
		result.setTestName(dto.getTestName());
		result.setInitTime(dto.getInitTime());
		result.setAccessTime(dto.getAccessTime());
		result.setDeleteTime(dto.getDeleteTime());
		result.setSortTime(dto.getInitTime());
		return result;
	}
	
	public static TestResultDTO TestResultToTestResultDTO(TestResult result) {
		TestResultDTO dto =  new TestResultDTO();
		dto.setTestName(result.getTestName());
		dto.setInitTime(result.getInitTime());
		dto.setAccessTime(result.getAccessTime());
		dto.setDeleteTime(result.getDeleteTime());
		dto.setSortTime(result.getInitTime());
		return dto;
	}
	
}
