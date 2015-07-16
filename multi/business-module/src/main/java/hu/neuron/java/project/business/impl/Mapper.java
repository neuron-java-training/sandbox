package hu.neuron.java.project.business.impl;

import hu.neuron.java.project.business.DataBVO;
import hu.neuron.java.project.persistens.DataVO;

import org.springframework.stereotype.Component;

@Component
public class Mapper {

	static DataBVO dataVoToDataBVo(DataVO dataVO) {
		DataBVO rv = new DataBVO();
		rv.setId(dataVO.getId());
		rv.setData1(dataVO.getData1());
		rv.setData2(dataVO.getData2());
		rv.setData3(dataVO.getData3());
		return rv;

	}

	static DataVO dataBVoToDataVo(DataBVO dataVO) {
		DataVO rv = new DataVO();
		rv.setId(dataVO.getId());
		rv.setData1(dataVO.getData1());
		rv.setData2(dataVO.getData2());
		rv.setData3(dataVO.getData3());
		return rv;

	}
}
