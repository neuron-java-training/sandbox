package hu.neruon.java.service.queue;

import hu.neuron.java.service.vo.MessageVO;

public interface TaskReciverSyncRemote {

	public MessageVO consume() throws Exception;
	
	public void browse() throws Exception;
}
