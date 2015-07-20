package hu.neuron.java.service;

import hu.neuron.java.service.vo.ResultVO;

import java.util.List;

public interface TestService {

	public void run(int initSize, int testSize);
	
	public List<ResultVO> getAverageOfResult();
	
}
