package hu.neuron.java.web.beans;

import hu.neuron.java.service.AsyncProcessorRemote;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "asyncProcess")
@ViewScoped
public class AsyncProcess {
	@EJB(mappedName = "AsyncProcessorBean", name = "AsyncProcessorBean")
	private AsyncProcessorRemote processorRemote;

	private Integer number;

	private Boolean inProgress = Boolean.FALSE;

	private Integer progress;

	public void start() {
		progress = 0;
		inProgress = Boolean.TRUE;
		processorRemote.addJob(getNumber());
	}

	public Integer checkProgress() {
		Integer progress = processorRemote.getProgress();
		if (progress == number) {
			inProgress = Boolean.FALSE;

		}

		Double i = (double) ((double) progress / (double) number) * 100;
		setProgress(i.intValue());
		return this.progress;
	}

	public Integer getNumber() {

		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Boolean getInProgress() {
		return inProgress;
	}

	public void setInProgress(Boolean inProgress) {
		this.inProgress = inProgress;
	}

	public Integer getProgress() {
		checkProgress(); 
		return progress;
	}

	public void setProgress(Integer progress) {
		this.progress = progress;
	}

}
