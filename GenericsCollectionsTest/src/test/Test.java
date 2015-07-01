package test;

import java.util.Collection;
import java.util.List;

import item.ComparableItem;
import item.Result;

public  interface Test {
	
	
	public  void init(Class<?> t);
	
	public void sort();
	
	public void getElement();
	
	public void delete();
	
	public Result getResult();





}
