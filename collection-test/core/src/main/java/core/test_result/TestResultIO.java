package core.test_result;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestResultIO implements IOOperationsInterface {

	public static final String FILE_PATH = "Result.txt";

	public TestResultIO() {
		super();
	}

	@Override
	public void read() {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(FILE_PATH)));
			try {
				while (true) {
					TestResult testResult = (TestResult) in.readObject();
					System.out.println(testResult);
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

	@Override
	public void writeList(java.util.List<TestResult> testResultList) {

		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(FILE_PATH)));
			for (TestResult tr : testResultList) {
				out.writeObject(tr);
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
	};

}
