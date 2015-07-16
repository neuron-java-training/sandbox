package hu.neuron.java.project.web;

import hu.neuron.java.project.business.DataBVO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataTableResponseWebVo implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<DataBVO> data = new ArrayList<>();

	public List<DataBVO> getData() {
		return data;
	}

	public void setData(List<DataBVO> data) {
		this.data = data;
	}
}
