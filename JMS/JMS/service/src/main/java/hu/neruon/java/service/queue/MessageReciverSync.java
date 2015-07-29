package hu.neruon.java.service.queue;

import hu.neuron.java.service.vo.MessageVO;

import java.util.Enumeration;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;

import org.apache.log4j.Logger;

/**
 * Message-Driven Bean implementation class for: MessageSubscriberA1
 */
@Singleton(name = "MessageReciverSync", mappedName = "MessageReciverSync")
@Remote(MessageReciverSyncRemote.class)
public class MessageReciverSync implements MessageReciverSyncRemote {
	private static final Logger logger = Logger
			.getLogger(MessageReciverSync.class);

	@Resource(name = "hu.neuron.java.ConnectionFactory")
	private QueueConnectionFactory connectionFactory;

	@Resource(name = "hu.neuron.java.QueueB")
	private Queue queue;

	@EJB(mappedName = "MessageStore", name = "MessageStore")
	MessageStoreRemote messageStoreRemote;

	public void consum() throws Exception {

		QueueConnection connection = null;
		QueueReceiver receiver = null;
		QueueSession session = null;
		try {
			connection = connectionFactory.createQueueConnection();
			session = connection.createQueueSession(false,
					Session.AUTO_ACKNOWLEDGE);

			receiver = session.createReceiver(queue);

			connection.start();
			ObjectMessage message = (ObjectMessage) receiver.receive();

			MessageVO messageVO = (MessageVO) message.getObject();

			logger.debug(messageVO);
			messageStoreRemote.addMessagesVo(messageVO);

		} finally {
			try {
				session.close();
			} catch (JMSException e1) {
				logger.error(e1.getMessage(), e1);
			}
			try {
				receiver.close();
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

	public void browse() throws Exception {

		QueueConnection connection = null;
		QueueBrowser queueBrowser = null;
		QueueSession session = null;
		try {
			connection = connectionFactory.createQueueConnection();
			session = connection.createQueueSession(false,
					Session.AUTO_ACKNOWLEDGE);

			queueBrowser = session.createBrowser(queue);

			connection.start();
			Enumeration e = queueBrowser.getEnumeration();
			int numMsgs = 0;
			// count number of messages
			while (e.hasMoreElements()) {
				Message message = (Message) e.nextElement();
				numMsgs++;
			}

			logger.debug(queue + " has " + numMsgs + " messages");

		} finally {
			try {
				session.close();
			} catch (JMSException e1) {
				logger.error(e1.getMessage(), e1);
			}
			try {
				queueBrowser.close();
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

	/**
	 * Default constructor.
	 */

	public MessageReciverSync() {
		// TODO Auto-generated constructor stub
	}

}
