package com.bdqn.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.bdqn.service.UserService;

public class UserTest {

	
	public static void main(String[] args) {
		//UserService service = new UserService();
		
		
		//ApplicationContext ����spring�ĺ�������    
		/*
		 * ApplicationContext����������   ��������Ķ�������������Ƕ���أ�
		 * ����������������ʱ�������
		       ���ߣ�ֻҪ�������ڣ�����һֱ����
	                  �������������٣���������������������������ں�������ͬ  
	          ApplicationContext ������mainִ����֮�� �ͽ�����       
	          
	          ������singleton  ������ʽ�����  ������� ����һ��     
	         prototype ԭ�ͷ�ʽ�����  ÿ��genbean�ͻ���һ��  �����������ʱ�䲻�ã��ͻ���java������������������  
	           
		 * 
		 */
//		/BeanFactory ���������
		
 
	 	//ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		//Ĭ����bean�ĵ�������   һ����ֻ��һ��ʵ��   һ����ֻ��һ������  
		//System.out.println("���سɹ�");
	/*	UserService service1 = (UserService) ac.getBean("userservice");
		UserService service2 = (UserService) ac.getBean("userservice");
		System.out.println(service1 == service2);*/ 
		
		//����Ҫ ҵ��� userservice�Ķ���
		/*
		service.save();*/
		//ac.close();
		//ac.close();//����ac����������
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory bs = new XmlBeanFactory(resource);
		System.out.println("==========================================");
		//���õ�ʱ�� �������  ���ò���
		UserService service1 = (UserService) bs.getBean("service");
	 
		service1.save();
	}
	
	 
}
