package kn;

import java.util.ArrayList;
import java.util.List;


public interface BoardInterface {
	
	List<Board> solutions = new ArrayList<>();
	
	public void init();
	
	public boolean isSafe(int Clm);
	
	public void Place(int Clm);
	
	public boolean IsGoal();
	
	public void UnPlace();
	
	

}
