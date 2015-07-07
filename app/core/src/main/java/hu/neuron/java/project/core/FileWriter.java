package hu.neuron.java.project.core;

import hu.neuron.java.project.common.interfaces.Writer;

import java.io.IOException;
import java.util.List;

public class FileWriter implements Writer {

	private java.io.FileWriter fw;
	private List<TestResult> results;
	private String pathAndFileName;

	public FileWriter(List<TestResult> tr, String name) {
		results = tr;
		pathAndFileName = name;
	}

	public void write() {
		String enter = System.getProperty("line.separator");
		try {
			fw = new java.io.FileWriter(pathAndFileName, true);
			for (TestResult testResult : results) {
				fw.write("---" + enter);
				fw.write(testResult.getCollectionName() + enter);
				fw.write((testResult.getInitTime() / TestResult.VIEWRATIO) + enter);
				fw.write((testResult.getFillTime() / TestResult.VIEWRATIO) + enter);
				fw.write((testResult.getSortTime() / TestResult.VIEWRATIO) + enter);
				fw.write((testResult.getAccessTime() / TestResult.VIEWRATIO) + enter);
				fw.write((testResult.getDeletionTime() / TestResult.VIEWRATIO) + enter);
				fw.write((testResult.getDuplicateEliminationTime() / TestResult.VIEWRATIO) + enter);
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
