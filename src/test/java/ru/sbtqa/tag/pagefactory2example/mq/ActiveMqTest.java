package ru.sbtqa.tag.pagefactory2example.mq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import ru.sbtqa.tag.mqfactory.MqFactory;
import ru.sbtqa.tag.mqfactory.exception.JmsException;
import ru.sbtqa.tag.mqfactory.exception.MqException;
import ru.sbtqa.tag.mqfactory.interfaces.Jms;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.QueueConnection;
import javax.jms.TextMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ActiveMqTest {
    private static final Logger LOG = LoggerFactory.getLogger(ActiveMqTest.class);
    public static final String AMQ_BROKER_URL = "tcp://localhost:61616";
    public static final String QUEUE_NAME = "testQueue";

    private ConnectionFactory mConnectionFactory;
    private JmsTemplate mJmsTemplate;
    private Jms<TextMessage> mq;

    @Before
    public void setUp() {
//        mConnectionFactory = new ActiveMQConnectionFactory(AMQ_BROKER_URL);
//        mJmsTemplate = new JmsTemplate(mConnectionFactory);
//        mJmsTemplate.setDefaultDestination(new ActiveMQQueue(QUEUE_NAME));
//        mJmsTemplate.setReceiveTimeout(500L);

        mq = getJmsTextMessage();
        Assert.assertNotNull(mq);
    }

    @Test
    public void sendMessages() throws MqException {
        List<String> messageIdList = new ArrayList<>();
        int size = mq.browseAllMessages(QUEUE_NAME).size();
        for (int i = 1; i <= 2; i++) {
            final int ii = i;
            messageIdList.add(mq.sendRequest(QUEUE_NAME, message -> {
                try {
                    message.setText("Test MQ " + ii);
                    message.setJMSCorrelationID("ID:111D11111D11111E111D1E111C1111111B1F1E1A1111EF11");
                } catch (JMSException e) {
                    throw new JmsException("Can't set text to message");
                }
                return message;
            }));
        }
        List<TextMessage> listAfterAdd = mq.browseAllMessages(QUEUE_NAME);
        Assert.assertEquals(size + messageIdList.size(), listAfterAdd.size());
        Assert.assertNotNull(listAfterAdd);
        for (TextMessage obj : listAfterAdd) {
            LOG.info(obj.toString());
        }
        // check, that first browse did not remove messages
        Assert.assertEquals(listAfterAdd.size(), mq.browseAllMessages(QUEUE_NAME).size());
    }

//    @Test
//    public void someIntegrationTest() throws JMSException {
//        LOG.info("Test starting...");
//        sendMessages();
//        receiveMessages();
//        LOG.info("Test done!");
//    }

//    private void sendMessages() {
//        for (int i = 1; i <= 10; i++) {
//            final int idx = i;
//            final String messageStr = "Message: " + idx;
//            LOG.info("Sending message with text: {}", messageStr);
//            mJmsTemplate.send(inJmsSession -> {
//                TextMessage textMessage = inJmsSession.createTextMessage(messageStr);
//                textMessage.setIntProperty("messageNumber", idx);
//                return textMessage;
//            });
//        }
//    }

//    private void receiveMessages() throws JMSException {
//        Message receivedMessage = mJmsTemplate.receive();
//        while (receivedMessage != null) {
//            if (receivedMessage instanceof TextMessage) {
//                final TextMessage textMessage = (TextMessage) receivedMessage;
//                LOG.info("Received a message with text: {}", textMessage.getText());
//            }
//            receivedMessage = mJmsTemplate.receive();
//        }
//        LOG.info("All messages received!");
//    }

    private Jms<TextMessage> getJmsTextMessage() {
        QueueConnection queueConnection = null;
        try {
            ActiveMQConnectionFactory mqCF = new ActiveMQConnectionFactory(AMQ_BROKER_URL);
            queueConnection = mqCF.createQueueConnection();
        } catch (JMSException ex) {
            LOG.error("", ex);
        }

        Assert.assertNotNull(queueConnection);
        Properties connProps = new Properties();
        connProps.put(MqFactory.MQ_TYPE, "activeMq");
        connProps.put(MqFactory.JMS_CONNECTION, queueConnection);
        return MqFactory.getMq(connProps);
    }
}
