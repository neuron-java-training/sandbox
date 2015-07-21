package hu.neuron.java.project.business.mapper;

import hu.neuron.java.project.business.bo.TestResultBO;
import hu.neuron.java.project.core.entity.TestResult;

public class TestResultMapper {

	public TestResultBO convertEntitytoBO(TestResult testResultEntity) {
		TestResultBO testResultBO = new TestResultBO(testResultEntity.getId(),
				testResultEntity.getName(), testResultEntity.getInitTime(),
				testResultEntity.getSortingTime(), testResultEntity.getFindItemTime(),
				testResultEntity.getDeleteItemsByRangeTime(),
				testResultEntity.getDuplicationClearTime());
		return testResultBO;
	}

	public TestResult convertBOtoEntity(TestResultBO testResultBO) {
		TestResult testResultEntity = new TestResult();
		testResultEntity.setId(testResultBO.getId());
		testResultEntity.setName(testResultBO.getName());
		testResultEntity.setInitTime(testResultBO.getInitTime());
		testResultEntity.setSortingTime(testResultBO.getSortingTime());
		testResultEntity.setFindItemTime(testResultBO.getFindItemTime());
		testResultEntity.setDeleteItemsByRangeTime(testResultBO.getDeleteItemsByRangeTime());
		testResultEntity.setDuplicationClearTime(testResultBO.getDuplicationClearTime());
		return testResultEntity;
	}
	
}
