package hu.neruon.java.service.queue;

public interface MessageSenderRemote {

	public void send(String message, MessageType type) throws Exception;
}
