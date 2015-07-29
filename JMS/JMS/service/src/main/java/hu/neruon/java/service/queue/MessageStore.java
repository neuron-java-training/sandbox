package hu.neruon.java.service.queue;

import hu.neuron.java.service.vo.MessageVO;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Singleton;

@Singleton(mappedName = "MessageStore", name = "MessageStore")
@Remote(MessageStoreRemote.class)
public class MessageStore implements MessageStoreRemote {

	ConcurrentHashMap<MessageType, List<String>> messages;
	CopyOnWriteArrayList<MessageVO> messageVOs;

	@PostConstruct
	public void init() {
		messages = new ConcurrentHashMap<MessageType, List<String>>();
		messageVOs = new CopyOnWriteArrayList<MessageVO>();
	}

	public List<String> getMessagesByType(MessageType messageType) {
		return messages.get(messageType);
	}

	public void addMessagesByType(String message, MessageType messageType) {
		List<String> list = messages.get(messageType);
		if (list == null) {
			messages.put(messageType, new ArrayList<String>());
		}
		messages.get(messageType).add(message);

	}

	public List<MessageVO> getMessageVOs() {
		return messageVOs;
	}

	public void addMessagesVo(MessageVO message) {
		messageVOs.add(message);

	}
}
