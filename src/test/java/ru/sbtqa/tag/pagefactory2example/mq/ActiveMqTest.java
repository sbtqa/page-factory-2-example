package ru.sbtqa.tag.pagefactory2example.mq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sbtqa.tag.mqfactory.MqFactory;
import ru.sbtqa.tag.mqfactory.exception.JmsException;
import ru.sbtqa.tag.mqfactory.exception.MqException;
import ru.sbtqa.tag.mqfactory.interfaces.Jms;

import javax.jms.JMSException;
import javax.jms.QueueConnection;
import javax.jms.TextMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * To start tests type in command line:
 * mvn -Dtest=ActiveMqTest test
 */
public class ActiveMqTest {
    private static final Logger LOG = LoggerFactory.getLogger(ActiveMqTest.class);
    public static final String AMQ_BROKER_URL = "tcp://localhost:61616";
    public static final String QUEUE_NAME = "testQueue";
    public static final int MESSAGE_COUNT = 3;

    private QueueConnection mQueueConnection;
    private Jms<TextMessage> mqService;

    @Before
    public void beforeTest() {
        mQueueConnection = null;
        mqService = createConnection();
    }

    @After
    public void afterTest() throws MqException, JMSException {
        mqService.removeAllMessages(QUEUE_NAME);
        if (mQueueConnection != null) {
            mQueueConnection.close();
        }
    }

    @Test
    public void browseMessages() throws MqException {
        LOG.info("");
        LOG.info("----- Start sending messages -----");
        for (int i = 1; i <= MESSAGE_COUNT; i++) {
            sendMQ(i, "Correlation_" + i);
        }
        LOG.info("----- End sending messages -----");

        LOG.info("");
        LOG.info("----- Start browsing messages -----");
        List<TextMessage> listAfterAdd = mqService.browseAllMessages(QUEUE_NAME);
        for (TextMessage message : listAfterAdd) {
            LOG.info(message.toString());
        }
        LOG.info("----- End browsing messages -----");
    }

    @Test
    public void getMessagesById() throws MqException {
        LOG.info("");
        LOG.info("----- Start sending messages -----");
        List<String> messageIdList = new ArrayList<>();
        for (int i = 1; i <= MESSAGE_COUNT; i++) {
            messageIdList.add(sendMQ(i, "Correlation_" + i));
        }
        LOG.info("----- End sending messages -----");

        LOG.info("");
        LOG.info("----- Start searching messages by ID -----");
        for (String messId : messageIdList) {
            TextMessage message = mqService.getMessageById(QUEUE_NAME, messId);
            LOG.info(message.toString());
        }
        LOG.info("----- End searching messages by ID -----");
    }

    @Test
    public void getMessageByParam() throws MqException {
        sendMQ(100500, "Correlation_100500");
        LOG.info("");
        LOG.info("----- Start getting message by param -----");
        List<TextMessage> messByCorrelList = mqService.getMessagesByParam(QUEUE_NAME, "JMSCorrelationID", "ID:Correlation_100500");
        LOG.info("List of JMSMessageID:");
        for (TextMessage message : messByCorrelList) {
            try {
                LOG.info("---> Message ID: {}; Message text: {}", message.getJMSMessageID(), message.getText());
            } catch (JMSException e) {
                LOG.error("", e);
            }
        }
        LOG.info("----- End getting message by param -----");
    }

    private String sendMQ(final int idx, final String correlationId) throws MqException {
        return mqService.sendRequest(QUEUE_NAME, message -> {
            try {
                message.setText("Test MQ " + idx);
                message.setJMSCorrelationID("ID:" + correlationId);
            } catch (JMSException e) {
                throw new JmsException("Can't set text to message");
            }
            return message;
        });
    }

    private Jms<TextMessage> createConnection() {
        QueueConnection queueConnection = null;
        try {
            ActiveMQConnectionFactory mqCF = new ActiveMQConnectionFactory(AMQ_BROKER_URL);
            queueConnection = mqCF.createQueueConnection();
        } catch (JMSException ex) {
            LOG.error("", ex);
        }

        Properties connProps = new Properties();
        connProps.put(MqFactory.MQ_TYPE, "activeMq");
        connProps.put(MqFactory.JMS_CONNECTION, queueConnection);
        mQueueConnection = queueConnection;
        return MqFactory.getMq(connProps);
    }
}
