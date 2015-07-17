package hu.neuron.java.project.core;

import hu.neuron.java.project.core.db.DAOFactory;
import hu.neuron.java.project.core.db.TestResultDAO;
import hu.neuron.java.project.common.interfaces.Writer;

import java.util.List;

public class SQLWriter implements Writer {

	private List<TestResult> results;

	public SQLWriter(List<TestResult> tr) {
		results = tr;
	}

	public void write() {

		//for (TestResult testResult : results) {

			DAOFactory instance = DAOFactory.getInstance();
			try {
				instance.beginConnectionScope();
				try {
					instance.beginTransaction();

					TestResultDAO dao = instance.getTestResultDAO();

					//dao.save(testResult);
					 for (TestResult testResult : results) {
						 dao.save(testResult);
					 }

					instance.endTransaction();
				} catch (Exception ex) {
					ex.printStackTrace();
					instance.abortTransaction();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					instance.endConnectionScope();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		//}
	}
}
