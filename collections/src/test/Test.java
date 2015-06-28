package test;

import run.Result;

public interface Test {
	
	public void init();
	
	public void sort();
	
	public void getElement(int startIndex);
	
	public void delete(int startIndex);
	
	public Result getResult();

}
