package hu.neuron.java.project.core;

import hu.neuron.java.common.IOinterface;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.transform.Result;

public class IO implements IOinterface {

	
	public void write(String name, List<Result> myList) {
		// TODO Auto-generated method stub

		DataOutputStream out = null;
		try {
			out = new DataOutputStream(new BufferedOutputStream(
					new FileOutputStream(name)));
			for (Result element : myList) {

				out.writeLong(element.getDeleteTime());
				out.writeLong(element.getInitTime());
				out.writeLong(element.getSortTime());
				out.writeLong(element.getGetTime());
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

	
	public void delete(String name) {
		// TODO Auto-generated method stub

	}

	
	public void read(String name, List<Result> myList) {
		// TODO Auto-generated method stub
		DataInputStream in = null;
		try {
			in = new DataInputStream(new BufferedInputStream(
					new FileInputStream(name)));
			while (true) {
				Result myResult = new Result();
				myResult.setDeleteTime(in.readLong());
				
				myResult.setInitTime(in.readLong());
				myResult.setSortTime(in.readLong());
				myResult.setGetTime(in.readLong());
				myList.add(myResult);

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
