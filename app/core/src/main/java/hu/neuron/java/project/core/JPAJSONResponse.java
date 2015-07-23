package hu.neuron.java.project.core;

import java.util.List;

public class JPAJSONResponse {
	
	List<WebVO> data;
	public JPAJSONResponse(List<WebVO> data){
		this.data = data;
	}
}
