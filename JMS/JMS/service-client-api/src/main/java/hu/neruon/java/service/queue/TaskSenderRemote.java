package hu.neruon.java.service.queue;

public interface TaskSenderRemote {

	public void send(String message) throws Exception;
}
