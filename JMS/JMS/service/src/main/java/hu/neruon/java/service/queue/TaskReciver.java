package hu.neruon.java.service.queue;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

/**
 * Message-Driven Bean implementation class for: MessageSubscriberA1
 */
@MessageDriven(mappedName = "hu.neuron.java.QueueIn", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")})
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class TaskReciver implements MessageListener {
	private static final Logger logger = Logger
			.getLogger(TaskReciver.class);

	@Resource
	private MessageDrivenContext mdc;

	@EJB(mappedName = "TaskSenderSync", name = "TaskSenderSync")
	private TaskSenderSyncRemote taskSenderSyncRemote;

	/**
	 * Default constructor.
	 */

	public TaskReciver() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message inMessage) {
		TextMessage msg = null;

		try {
			if (inMessage instanceof TextMessage) {
				msg = (TextMessage) inMessage;
				for(int i = 0; i < Integer.valueOf(msg.getText()); i++){
					taskSenderSyncRemote.send(String.valueOf(i));
				}
			} else {
				logger.warn("Message of wrong type: "
						+ inMessage.getClass().getName());
			}
		} catch (JMSException e) {
			e.printStackTrace();
			mdc.setRollbackOnly();
		} catch (Throwable te) {
			te.printStackTrace();
		}
	}

}
