package hu.neuron.test;

import hu.neuron.runner.Result;

public interface Teszt
{	
	public void init();
	public void rendez();
	public void listaz(int db);
	public void delete(int from);
	
	public Result getResult();
}
