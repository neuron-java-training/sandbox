package hu.neuron.java.project.app;

public interface Test {
	
	public void initBegin();
	
	public void initEnd();

	long fill();

	long order();

	long delete(int s, int e);

}
