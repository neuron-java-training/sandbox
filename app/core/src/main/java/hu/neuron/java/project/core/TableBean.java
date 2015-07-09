package hu.neuron.java.project.core;

import java.io.Serializable;

public class TableBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tableData;
	private boolean valid;
	
	public TableBean(){
		valid = false;
	}

	public String getTableData() {
		return tableData;
	}

	public void setTableData(String tableData) {
		this.tableData = tableData;
	}

	public boolean getValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	
	
}
