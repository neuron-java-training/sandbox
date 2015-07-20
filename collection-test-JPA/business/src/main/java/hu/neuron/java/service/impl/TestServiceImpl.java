package hu.neuron.java.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.neuron.java.business.collection_test.list_test.ArrayListTester;
import hu.neuron.java.business.collection_test.list_test.LinkedListTester;
import hu.neuron.java.business.collection_test.set_test.HashSetTester;
import hu.neuron.java.business.collection_test.set_test.LinkedHashSetTester;
import hu.neuron.java.business.collection_test.set_test.TreeSetTester;
import hu.neuron.java.business.collection_test.testRunner.TestRunner;
import hu.neuron.java.persistence.dao.ResultDAO;
import hu.neuron.java.service.TestService;
import hu.neuron.java.service.converter.ResultConverter;
import hu.neuron.java.service.vo.ResultVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TestServiceImpl implements TestService {

	@Autowired
	ResultDAO resultDAO;
	
	@Override
	public void run(int initSize, int testSize) {
		TestRunner testRunner = new TestRunner();
		testRunner.addTest(new ArrayListTester(initSize, testSize));
		testRunner.addTest(new LinkedListTester(initSize, testSize));
		testRunner.addTest(new TreeSetTester(initSize, testSize));
		testRunner.addTest(new LinkedHashSetTester(initSize, testSize));
		testRunner.addTest(new HashSetTester(initSize, testSize));
		testRunner.runAllTest();

		List<ResultVO> resultList = testRunner.getResultList();

		for (ResultVO testResult : resultList) {
			try {
				resultDAO.save(ResultConverter.toDTO(testResult));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<ResultVO> getAverageOfResult() {
		try {
			return ResultConverter.toVO(resultDAO.getAverages());
		} catch (Exception e) {
			return new ArrayList<ResultVO>();
		}
	}

}
