package hu.neuron.java.project.core;

import hu.neuron.java.project.core.db.TestResultDAO;
import hu.neuron.java.project.common.interfaces.Writer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JPAWriter implements Writer<TestResult> {

	private List<TestResult> results;

	@Autowired
	private TestResultDAO dao;

	public JPAWriter() {
	}

	public JPAWriter(List<TestResult> results) {
		this.results = results;
	}

	public void write() {

		for (TestResult testResult : results) {
			dao.save(testResult);
		}
	}

	public void setResults(List<TestResult> tr) {
		results = tr;
	}
}
