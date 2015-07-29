package hu.neuron.java.web.beans;

import hu.neuron.java.service.TimerRemote;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "jsfTimerBean")
@SessionScoped
public class JsfTimerBean {
	private int value;

	@EJB(mappedName = "TimerBean", name = "TimerBean")
	TimerRemote remote;

	public void getChecks() {
		value = remote.getChecks();
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
