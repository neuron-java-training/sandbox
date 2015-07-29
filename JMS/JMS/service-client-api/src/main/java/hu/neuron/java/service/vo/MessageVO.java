package hu.neuron.java.service.vo;

import java.io.Serializable;
import java.util.Calendar;

public class MessageVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;
	private Calendar date;
	
	public MessageVO(){}
	
	public MessageVO(String message, Calendar date){
		this.message = message;
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

}
