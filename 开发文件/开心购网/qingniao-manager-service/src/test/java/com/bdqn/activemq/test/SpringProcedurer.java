package com.bdqn.activemq.test;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class SpringProcedurer {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-activemq.xml");
		
		JmsTemplate session = (JmsTemplate) ac.getBean("jmsTemplate");
		//1\ 造生产者  2、造消息  3、生产者发送消息
		Queue destination = ac.getBean(ActiveMQQueue.class);
		session.send(destination, new MessageCreator() {
			@Override
			public Message createMessage(Session arg0) throws JMSException {
				TextMessage textMessage = arg0.createTextMessage("商品 ");
				return textMessage;
			}
		});
		 
	}
}
