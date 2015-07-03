package hu.neuron.java.project.core;

import hu.neuron.java.project.common.Stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class IO implements Stream {

	static final String dataFile = "test";

	public IO() {
	}

	public void write(List<?> t) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(
					new FileOutputStream(dataFile)));
			for (int i = 0; i < t.size(); i++) {
				Object a = t.get(i);
				out.writeObject(a);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}

		}

	}

	public void read() {
		ObjectInputStream in = null;
		try {

			in = new ObjectInputStream(new BufferedInputStream(
					new FileInputStream(dataFile)));
			try {
				while (true) {
					Object a = in.readObject();
					System.out.println(a);
				}
			} catch (EOFException e) {
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
	}
}