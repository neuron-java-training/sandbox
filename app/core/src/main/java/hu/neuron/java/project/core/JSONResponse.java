package hu.neuron.java.project.core;

import java.util.List;

public class JSONResponse {
	
	List<TestResultVO> data;
	public JSONResponse(List<TestResultVO> data){
		this.data = data;
	}
}
