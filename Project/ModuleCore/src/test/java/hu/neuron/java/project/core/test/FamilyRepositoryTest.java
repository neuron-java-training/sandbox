package hu.neuron.java.project.core.test;

import hu.neuron.java.project.core.entity.TestResult;
import hu.neuron.java.project.core.repository.TestResultRepository;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-test-core.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class FamilyRepositoryTest {
	
	@Autowired
	TestResultRepository testResultRepository;

	@Test
	public void test1saveTestResult() {
		TestResult entity = new TestResult();
		entity.setName("Family");

		testResultRepository.save(entity);
	}
}
