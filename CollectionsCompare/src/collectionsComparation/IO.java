package collectionsComparation;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IO {
	
	long sum1 = 0, sum2 = 0;

	public IO() {

	}

	public long getSum1() {
		return sum1;
	}

	public void setSum1(long sum1) {
		this.sum1 = sum1;
	}

	public long getSum2() {
		return sum2;
	}

	public void setSum2(long sum2) {
		this.sum2 = sum2;
	}

	public void delete(String fileName) {

		try {
			
			File file = new File(fileName);
			file.delete();
			
		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public void write(TestResults testresults, String fileName) {
		long data1 = 0, data2 = 0;
		DataOutputStream out = null;
		try {
			out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));

			data1 = testresults.getLinkedListResult();
			data2 = testresults.getArrayListResult();
			out.writeLong(data1);
			out.writeUTF(";");
			out.writeLong(data2);

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

	public void read(String fileName) {
		DataInputStream in = null;
		long input1 = 0, input2 = 0;
		try {

			in = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
			try {

				input1 = in.readLong();
				setSum1(getSum1() + input1);
				in.readUTF();
				input2 = in.readLong();
				setSum2(getSum2() + input2);

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
		// System.out.println("From the '" + fileName + "' file : " + input1 +
		// ";" + input2);
	}

}
