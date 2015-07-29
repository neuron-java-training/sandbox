package hu.neruon.java.service.queue;

import hu.neuron.java.service.vo.MessageVO;

public interface MessageSenderSyncRemote {

	public void send(MessageVO message) throws Exception;
}
