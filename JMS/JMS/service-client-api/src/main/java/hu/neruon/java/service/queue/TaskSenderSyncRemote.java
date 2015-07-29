package hu.neruon.java.service.queue;

public interface TaskSenderSyncRemote {

	public void send(String message) throws Exception;
}
