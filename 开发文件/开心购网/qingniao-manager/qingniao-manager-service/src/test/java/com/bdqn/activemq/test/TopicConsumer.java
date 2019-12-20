package com.bdqn.activemq.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class TopicConsumer {

	public static void main(String[] args) throws Exception {
 
		
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.128.128:61616");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		
		Topic destination = session.createTopic("8101-topic");
		MessageConsumer consumer = session.createConsumer(destination);
		
		consumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message message) {
				TextMessage textmessage = (TextMessage) message;
				try {
					
					String str = textmessage.getText();
					System.out.println(str);
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}); 
		
		InputStream in = System.in;
		in.read();
		
		consumer.close();
		session.close();
		connection.close();
 
	}
}
