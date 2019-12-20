package com.bdqn.activemq.test;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class TopicProcedure {

	public static void main(String[] args) throws Exception {

		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.128.128:61616");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		
		Topic destination = session.createTopic("8101-topic");
		
		MessageProducer producer = session.createProducer(destination);
		
		TextMessage message = session.createTextMessage("hello  topic  how are you i missed you so much");
		producer.send(message);
		
		producer.close();
		session.close();
		connection.close();
		
		
		
	}
}
