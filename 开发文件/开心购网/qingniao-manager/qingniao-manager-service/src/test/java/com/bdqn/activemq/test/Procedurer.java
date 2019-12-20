package com.bdqn.activemq.test;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Procedurer {

	public static void main(String[] args) throws Exception {
		
		
		
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.128.128:61616");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		
		Queue queue = session.createQueue("8101-queue");
		MessageProducer producer = session.createProducer(queue);
		TextMessage message = session.createTextMessage("hello  welcome to  queue");
		
		producer.send(message);
		
		producer.close();
		session.close();
		connection.close();

		
	}
}
