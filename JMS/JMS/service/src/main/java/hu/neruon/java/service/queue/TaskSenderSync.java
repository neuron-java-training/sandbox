package hu.neruon.java.service.queue;

import java.util.Calendar;

import hu.neuron.java.service.vo.MessageVO;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;

import org.apache.log4j.Logger;

@Singleton(mappedName = "TaskSenderSync", name = "TaskSenderSync")
@Remote(TaskSenderSyncRemote.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class TaskSenderSync implements TaskSenderSyncRemote {
	private static final Logger logger = Logger
			.getLogger(TaskSenderSync.class);

	@Resource(name = "hu.neuron.java.ConnectionFactory")
	private QueueConnectionFactory connectionFactory;
	@Resource(name = "hu.neuron.java.QueueOut")
	private Queue queue;

	public void send(String message) throws Exception {

		QueueConnection connection = null;
		QueueSender sender = null;
		QueueSession session = null;
		try {
			connection = connectionFactory.createQueueConnection();
			session = connection.createQueueSession(false,
					Session.AUTO_ACKNOWLEDGE);

			sender = session.createSender(queue);

			ObjectMessage messageOut = session.createObjectMessage();

			messageOut.setObject(new MessageVO(String.valueOf(message), Calendar.getInstance()));

			sender.send(messageOut);

		} finally {
			try {
				session.close();
			} catch (JMSException e1) {
				logger.error(e1.getMessage(), e1);
			}
			try {
				sender.close();
			} catch (JMSException e2) {
				logger.error(e2.getMessage(), e2);
			}
			try {
				connection.close();
			} catch (JMSException e3) {
				logger.error(e3.getMessage(), e3);
			}
		}

	}
}
