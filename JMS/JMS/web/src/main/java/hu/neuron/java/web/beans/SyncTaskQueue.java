package hu.neuron.java.web.beans;

import java.util.LinkedList;
import java.util.List;

import hu.neruon.java.service.queue.TaskReciverSyncRemote;
import hu.neuron.java.service.vo.MessageVO;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "syncTaskQueue")
@ViewScoped
public class SyncTaskQueue {

	@EJB(name = "TaskReciverSync", mappedName = "TaskReciverSync")
	private TaskReciverSyncRemote taskReciverSyncRemote;

	private MessageVO message;
	
	private List<MessageVO> messageVOs;
	
	@PostConstruct
	public void init(){
		messageVOs = new LinkedList<>();
	}

	public void showMessage() {
		MessageVO messageVO = null;
		try {
			messageVO = taskReciverSyncRemote.consume();
		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
		}
		if(messageVO != null){
			messageVOs.add(messageVO);
		}

	}

	public MessageVO getMessage() {
		return message;
	}

	public void setMessage(MessageVO message) {
		this.message = message;
	}
	
	public List<MessageVO> getMessageVOs() {
		return messageVOs;
	}

	public void setMessageVOs(List<MessageVO> messageVOs) {
		this.messageVOs = messageVOs;
	}

}
