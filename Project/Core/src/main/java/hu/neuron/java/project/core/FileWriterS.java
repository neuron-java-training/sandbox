package hu.neuron.java.project.core;

import hu.neuron.java.project.common.FileWriterSInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileWriterS implements FileWriterSInterface {

	@Override
	public void writeFile(String fileNamePath, boolean append, Object ob) {
		// TODO Auto-generated method stub
		try (PrintWriter output = new PrintWriter(new FileWriter(fileNamePath, append))) {
			output.println(ob);
		} catch (Exception e) {
		}

	}

	@Override
	public ArrayList<TestResult> readFile() {
		// TODO Auto-generated method stub
		boolean fileCheck = true;
		int fileCounter = 0;
		ArrayList<TestResult> resultAvg = new ArrayList<TestResult>();
		TestResult arrayTest = new TestResult("arrayTest");
		TestResult treeTest = new TestResult("treeTest");
		TestResult listTest = new TestResult("listTest");

		while (fileCheck) {
			if (!new File("result//test" + fileCounter + "result.txt").isFile()) {
				fileCheck = false;
			} else {
				try (BufferedReader br = new BufferedReader(new FileReader("result//test"
						+ fileCounter + "result.txt"))) {
					String line;
					String splittedline[];
					while ((line = br.readLine()) != null) {
						splittedline = line.split(" ");
						if (splittedline[0].equals("listTest")) {
							listTest.setInitTime(listTest.getInitTime()
									+ (long) ((Double.parseDouble(splittedline[2]) * 1_000_000)));
							listTest.setSortingTime(listTest.getSortingTime()
									+ (long) ((Double.parseDouble(splittedline[4]) * 1_000_000)));
							listTest.setGetItemTime(listTest.getGetItemTime()
									+ (long) ((Double.parseDouble(splittedline[6]) * 1_000_000)));
							listTest.setDeleteItemsByRangeTime(listTest.getDeleteItemsByRangeTime()
									+ (long) ((Double.parseDouble(splittedline[8]) * 1_000_000)));
							listTest.setDuplicationClearTime(listTest.getDuplicationClearTime()
									+ (long) ((Double.parseDouble(splittedline[10]) * 1_000_000)));
						}
						if (splittedline[0].equals("arrayTest")) {
							arrayTest.setInitTime(arrayTest.getInitTime()
									+ (long) ((Double.parseDouble(splittedline[2]) * 1_000_000)));
							arrayTest.setSortingTime(arrayTest.getSortingTime()
									+ (long) ((Double.parseDouble(splittedline[4]) * 1_000_000)));
							arrayTest.setGetItemTime(arrayTest.getGetItemTime()
									+ (long) ((Double.parseDouble(splittedline[6]) * 1_000_000)));
							arrayTest.setDeleteItemsByRangeTime(arrayTest
									.getDeleteItemsByRangeTime()
									+ (long) ((Double.parseDouble(splittedline[8]) * 1_000_000)));
							arrayTest.setDuplicationClearTime(arrayTest.getDuplicationClearTime()
									+ (long) ((Double.parseDouble(splittedline[10]) * 1_000_000)));
						}
						if (splittedline[0].equals("treeTest")) {
							treeTest.setInitTime(treeTest.getInitTime()
									+ (long) ((Double.parseDouble(splittedline[2]) * 1_000_000)));
							treeTest.setSortingTime(treeTest.getSortingTime()
									+ (long) ((Double.parseDouble(splittedline[4]) * 1_000_000)));
							treeTest.setGetItemTime(treeTest.getGetItemTime()
									+ (long) ((Double.parseDouble(splittedline[6]) * 1_000_000)));
							treeTest.setDeleteItemsByRangeTime(treeTest.getDeleteItemsByRangeTime()
									+ (long) ((Double.parseDouble(splittedline[8]) * 1_000_000)));
							treeTest.setDuplicationClearTime(treeTest.getDuplicationClearTime()
									+ (long) ((Double.parseDouble(splittedline[10]) * 1_000_000)));
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
				}
				fileCounter++;
			}
		}
		if (new File("result//test" + 0 + "result.txt").isFile()) {
			listTest.setInitTime((long) ((double) listTest.getInitTime() / fileCounter));
			listTest.setSortingTime((long) ((double) listTest.getSortingTime() / fileCounter));
			listTest.setGetItemTime((long) ((double) listTest.getGetItemTime() / fileCounter));
			listTest.setDeleteItemsByRangeTime((long) ((double) listTest
					.getDeleteItemsByRangeTime() / fileCounter));
			listTest.setDuplicationClearTime((long) ((double) listTest.getDuplicationClearTime() / fileCounter));

			arrayTest.setInitTime((long) ((double) arrayTest.getInitTime() / fileCounter));
			arrayTest.setSortingTime((long) ((double) arrayTest.getSortingTime() / fileCounter));
			arrayTest.setGetItemTime((long) ((double) arrayTest.getGetItemTime() / fileCounter));
			arrayTest.setDeleteItemsByRangeTime((long) ((double) arrayTest
					.getDeleteItemsByRangeTime() / fileCounter));
			arrayTest
					.setDuplicationClearTime((long) ((double) arrayTest.getDuplicationClearTime() / fileCounter));

			treeTest.setInitTime((long) ((double) treeTest.getInitTime() / fileCounter));
			treeTest.setSortingTime((long) ((double) treeTest.getSortingTime() / fileCounter));
			treeTest.setGetItemTime((long) ((double) treeTest.getGetItemTime() / fileCounter));
			treeTest.setDeleteItemsByRangeTime((long) ((double) treeTest
					.getDeleteItemsByRangeTime() / fileCounter));
			treeTest.setDuplicationClearTime((long) ((double) treeTest.getDuplicationClearTime() / fileCounter));
			
			resultAvg.add(listTest);
			resultAvg.add(arrayTest);
			resultAvg.add(treeTest);
		}		
		return resultAvg;

	}

}
