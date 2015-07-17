package hu.neuron.java.project.core;

import java.util.List;

public class SQLJSONResponse {
	
	List<WebVO> data;
	public SQLJSONResponse(List<WebVO> data){
		this.data = data;
	}
}
