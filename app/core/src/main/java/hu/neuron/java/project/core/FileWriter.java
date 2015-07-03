package hu.neuron.java.project.core;

import hu.neuron.java.project.common.interfaces.Writer;

import java.io.IOException;

public class FileWriter implements Writer{

	private java.io.FileWriter fw;
	private TestResult testResult;
	
	public FileWriter(TestResult tr){
		testResult = tr;
	}
	
	public void write() {
		synchronized(this){
			String enter = System.getProperty("line.separator");
			try {
				fw = new java.io.FileWriter("results.txt",true);
				fw.write("---" + enter);
				fw.write(testResult.getCollectionName() + enter);
				fw.write((testResult.getInitTime()/TestResult.VIEWRATIO) + enter);
				fw.write((testResult.getFillTime() / TestResult.VIEWRATIO) + enter);
				fw.write((testResult.getSortTime() / TestResult.VIEWRATIO) + enter);
				fw.write((testResult.getAccessTime()/ TestResult.VIEWRATIO) + enter);
				fw.write((testResult.getDeletionTime() / TestResult.VIEWRATIO) + enter);
				fw.write((testResult.getDuplicateEliminationTime() / TestResult.VIEWRATIO) + enter);
				fw.flush();
				fw.close();
			} catch (IOException e) {
			}
		}
	}

}
