package hu.neuron.java.project.core;

import java.io.IOException;
import java.util.List;

import hu.neuron.java.project.common.interfaces.Writer;

public class HTMLWriter implements Writer {

	private String path;
	private java.io.FileWriter fw;
	private List<AverageResult> results;

	public HTMLWriter(List<AverageResult> tr, String path) {
		results = tr;
    	this.path = path;
	}
	
	@Override
	public void write() {
		String enter = System.getProperty("line.separator");
		try {
			fw = new java.io.FileWriter(path+"cache/cache.html", false);
			for (AverageResult ar : results) {
 				StringBuffer sb = new StringBuffer();
 				sb.append("<tr>");
 					sb.append("<td>");
 						sb.append(ar.getCollectionName());
 					sb.append("</td>");
 					sb.append("<td>");
 						sb.append(ar.getN());
 					sb.append("</td>");
 					sb.append("<td>");
 						sb.append(ar.getAverageAccessTime() / TestResult.VIEWRATIO);
 					sb.append("</td>");
 					sb.append("<td>");
 						sb.append(ar.getAverageDeletionTime() / TestResult.VIEWRATIO);
 					sb.append("</td>");
 					sb.append("<td>");
 						sb.append(ar.getAverageDuplicateEliminationTime() / TestResult.VIEWRATIO);
 					sb.append("</td>");
 					sb.append("<td>");
 						sb.append(ar.getAverageFillTime() / TestResult.VIEWRATIO);
 					sb.append("</td>");
 					sb.append("<td>");
 						sb.append(ar.getAverageInitTime() / TestResult.VIEWRATIO);
 					sb.append("</td>");
 					sb.append("<td>");
						sb.append(ar.getAverageSortTime() / TestResult.VIEWRATIO);
					sb.append("</td>");
 				sb.append("</tr>");
 				sb.append(enter);
 				fw.write(sb.toString());
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
