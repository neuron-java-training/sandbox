package hu.neruon.java.service.queue;

public interface TaskSenderOutRemote {

	public void send(String message) throws Exception;
}
