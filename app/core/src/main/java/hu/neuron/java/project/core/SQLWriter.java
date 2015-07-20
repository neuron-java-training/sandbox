package hu.neuron.java.project.core;

import hu.neuron.java.project.core.db.TestResultDAO;
import hu.neuron.java.project.common.interfaces.Writer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SQLWriter implements Writer {

	private List<TestResult> results;

	@Autowired
	private TestResultDAO dao;

	public SQLWriter() {
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
