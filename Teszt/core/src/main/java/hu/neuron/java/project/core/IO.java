package hu.neuron.java.project.core;




import hu.neuron.java.project.common.IOInterface;
import hu.neuron.java.project.common.Result;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IO implements IOInterface {

	@Override
	public  void write(Result res) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter("res.txt", true));
			System.out.println(res.res());
			out.println(res.res());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

	@Override
	public  void read() {

		List<String> lines = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader("res.txt"))) {
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				lines.add(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		Map<String, Integer[]> sum = new HashMap<>();

		System.out.println();

		for (int i = 0; i < lines.size(); i++) {
			String[] tmp = lines.get(i).split(", ");

			Integer[] t = new Integer[4];
			for (int j = 0; j < t.length; j++) {
				t[j] = Integer.parseInt(tmp[j + 1]);
			}

			if (sum.containsKey(tmp[0])) {
				Integer[] results = sum.get(tmp[0]);
				for (int j = 0; j < results.length; j++) {
					results[j] += t[j];
				}
			} else {
				sum.put(tmp[0], t);
			}
		}

		for (String key : sum.keySet()) {

			System.out.print(key);
			Integer[] avg = sum.get(key);
			for (int i = 0; i < avg.length; i++) {
				System.out.print(" " + avg[i] / (lines.size() / sum.size() ) + " ");
			}
			System.out.println();
		}

	}

}
