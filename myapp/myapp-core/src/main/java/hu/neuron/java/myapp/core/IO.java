package hu.neuron.java.myapp.core;

import hu.neuron.java.myapp.common.Stream;

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
	
	static String dataFile = "test";
	
	public IO(){
	}
	
	@Override
	public void write(List<?> t) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(
					new FileOutputStream(dataFile)));
			for (int i = 0; i < t.size(); i++) {
				Object obj = t.get(i);
				out.writeObject(obj);
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

	@Override
	public void read() {
		ObjectInputStream in = null;
		try {

			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)));
			try {
				while (true) {
					Object obj = in.readObject();
					
					System.out.println(obj);
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

