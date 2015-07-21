package hu.neuron.java.project.business.impl;

import hu.neuron.java.project.business.api.CollectionTestInterface;
import hu.neuron.java.project.business.bo.TestResultBO;
import hu.neuron.java.project.business.mapper.TestResultMapper;
import hu.neuron.java.project.core.entity.TestResult;
import hu.neuron.java.project.core.repository.TestResultRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class CollectionTestThread<T extends CollectionTestInterface> implements Runnable {

	@Autowired
	TestResultRepository testResultRepository;

	private TestResultMapper testResultMapper = new TestResultMapper();

	private TestResultBO testResultBO = new TestResultBO();
	private T testCollection;

	private long timer = 0;

	public CollectionTestThread(T testCollection, String name) {
		// TODO Auto-generated constructor stub
		testResultBO.setName(name);
		this.testCollection = testCollection;
	}

	public void run() {
		testResultBO.setId(null);

		timer = System.nanoTime();
		testCollection.init();
		testResultBO.setInitTime(System.nanoTime() - timer);

		timer = System.nanoTime();
		testCollection.sorting();
		testResultBO.setSortingTime(System.nanoTime() - timer);

		timer = System.nanoTime();
		testCollection.findItem(10);
		testResultBO.setFindItemTime(System.nanoTime() - timer);

		timer = System.nanoTime();
		testCollection.deleteItemsByRange(10, 15);
		testResultBO.setDeleteItemsByRangeTime(System.nanoTime() - timer);

		timer = System.nanoTime();
		testCollection.duplicationClear();
		testResultBO.setDuplicationClearTime(System.nanoTime() - timer);

		try {
			TestResult testResultEntity = testResultMapper.convertBOtoEntity(testResultBO);
			testResultRepository.save(testResultEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
