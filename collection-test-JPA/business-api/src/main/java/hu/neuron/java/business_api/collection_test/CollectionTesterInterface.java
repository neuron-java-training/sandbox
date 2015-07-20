package hu.neuron.java.business_api.collection_test;

import hu.neuron.java.service.vo.ResultVO;

import java.util.List;

public interface CollectionTesterInterface {

	public List<ResultVO> run(int initSize, int testSize);
	
	public List<ResultVO> getAverageOfResult();
	
}
