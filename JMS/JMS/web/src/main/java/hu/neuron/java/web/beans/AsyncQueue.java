package hu.neuron.java.web.beans;

import java.util.List;

import hu.neruon.java.service.queue.MessageSenderRemote;
import hu.neruon.java.service.queue.MessageStoreRemote;
import hu.neruon.java.service.queue.MessageType;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "asyncQueue")
@ViewScoped
public class AsyncQueue {
	@EJB(mappedName = "MessageSender", name = "MessageSender")
	private MessageSenderRemote messageSenderRemote;

	@EJB(mappedName = "MessageStore", name = "MessageStore")
	MessageStoreRemote messageStoreRemote;

	private String message;

	private String type;

	private List<String> aTypeMessages;

	private List<String> bTypeMessages;

	public void sendMessage() {
		try {
			messageSenderRemote.send(message, MessageType.valueOf(getType()));
		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
		}
	}

	public void checkMessages() {
		aTypeMessages = messageStoreRemote.getMessagesByType(MessageType.A);

		bTypeMessages = messageStoreRemote.getMessagesByType(MessageType.B);

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MessageSenderRemote getMessageSenderRemote() {
		return messageSenderRemote;
	}

	public void setMessageSenderRemote(MessageSenderRemote messageSenderRemote) {
		this.messageSenderRemote = messageSenderRemote;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getaTypeMessages() {
		return aTypeMessages;
	}

	public void setaTypeMessages(List<String> aTypeMessages) {
		this.aTypeMessages = aTypeMessages;
	}

	public List<String> getbTypeMessages() {
		return bTypeMessages;
	}

	public void setbTypeMessages(List<String> bTypeMessages) {
		this.bTypeMessages = bTypeMessages;
	}

}
