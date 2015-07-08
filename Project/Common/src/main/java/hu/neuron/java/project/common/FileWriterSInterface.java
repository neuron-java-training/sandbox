package hu.neuron.java.project.common;

public interface FileWriterSInterface<T extends Object> {
	void writeFile(String fileName,boolean append,Object ob);
	T readFile();
}
