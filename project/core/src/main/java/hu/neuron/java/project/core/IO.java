package hu.neuron.java.project.core;

import hu.neuron.java.project.common.IOInterface;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class IO implements IOInterface {
	private final String dataFile = "data.txt";

	public String read() {
		String str = "";
		FileReader fr = null;
		Scanner sc;
		try {
			fr = new FileReader(dataFile);
			sc = new Scanner(fr);

			while (sc.hasNextLine()) {

				str += sc.nextLine();

			}
		} catch (Exception e) {

		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {

				}
			}
		}

		return str;

	}

	public void write(ArrayList<Object> list) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(dataFile, false);
			for (Object test : list) {
				fw.write(test.toString() + ";");
			}

		} catch (Exception e) {

		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {

				}
			}
		}

	}

}
