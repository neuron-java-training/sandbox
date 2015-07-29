package hu.neruon.java.service.queue;

import hu.neuron.java.service.vo.MessageVO;

import java.util.List;

public interface MessageStoreRemote {
	public List<String> getMessagesByType(MessageType messageType);

	public void addMessagesByType(String message, MessageType messageType);

	public List<MessageVO> getMessageVOs();

	public void addMessagesVo(MessageVO message);
}
