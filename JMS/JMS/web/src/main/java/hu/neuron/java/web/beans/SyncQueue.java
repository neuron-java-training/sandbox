package hu.neuron.java.web.beans;

import java.util.Calendar;
import java.util.List;

import hu.neruon.java.service.queue.MessageReciverSyncRemote;
import hu.neruon.java.service.queue.MessageSenderSyncRemote;
import hu.neruon.java.service.queue.MessageStoreRemote;
import hu.neuron.java.service.vo.MessageVO;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "syncQueue")
@ViewScoped
public class SyncQueue {
	@EJB(mappedName = "MessageSenderSync", name = "MessageSenderSync")
	private MessageSenderSyncRemote messageSenderSyncRemote;

	@EJB(name = "MessageReciverSync", mappedName = "MessageReciverSync")
	private MessageReciverSyncRemote messageReciverSyncRemote;

	@EJB(mappedName = "MessageStore", name = "MessageStore")
	MessageStoreRemote messageStoreRemote;

	private String message;

	private List<MessageVO> messageVOs;

	public void sendMessage() {
		try {
			MessageVO messageVo = new MessageVO();

			messageVo.setMessage(message);
			messageVo.setDate(Calendar.getInstance());
			messageSenderSyncRemote.send(messageVo);
		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
		}
	}

	public void checkMessages() {
		try {
			messageReciverSyncRemote.consum();
		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
		}
		setMessageVOs(messageStoreRemote.getMessageVOs());

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<MessageVO> getMessageVOs() {
		return messageVOs;
	}

	public void setMessageVOs(List<MessageVO> messageVOs) {
		this.messageVOs = messageVOs;
	}

}
