package com.bdqn.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bdqn.service.UserService;
import com.bdqn.service.impl.UserServiceImpl;

public class UserTest {

	public static void main(String[] args) {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		//取业务层对象
		UserService service = (UserService) ac.getBean("service");
		//UserServiceImpl service = (UserServiceImpl) ac.getBean("service");
		int m = service.save();
		System.out.println(m);
		
	}
}
