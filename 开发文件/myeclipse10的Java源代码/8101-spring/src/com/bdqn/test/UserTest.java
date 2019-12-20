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
		
		
		//ApplicationContext 就是spring的核心容器    
		/*
		 * ApplicationContext的生命周期   和造出来的对象的生命周期是多久呢？
		 * 出生：当容器创建时对象出生
		       或者：只要容器还在，对象一直活着
	                  死亡：容器销毁，对象消亡，单例对象的生命周期和容器相同  
	          ApplicationContext 对象在main执行完之后 就结束了       
	          
	          作用域：singleton  单例方式造对象  作用域和 容器一样     
	         prototype 原型方式造对象  每次genbean就会造一个  作用域：如果长时间不用，就会有java的垃圾回收器给回收  
	           
		 * 
		 */
//		/BeanFactory 造多例对象
		
 
	 	//ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		//默认造bean的单例对象   一个类只有一个实例   一个类只有一个对象  
		//System.out.println("加载成功");
	/*	UserService service1 = (UserService) ac.getBean("userservice");
		UserService service2 = (UserService) ac.getBean("userservice");
		System.out.println(service1 == service2);*/ 
		
		//伸手要 业务层 userservice的对象
		/*
		service.save();*/
		//ac.close();
		//ac.close();//结束ac的生命周期
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory bs = new XmlBeanFactory(resource);
		System.out.println("==========================================");
		//调用的时候 就造对象  不用不造
		UserService service1 = (UserService) bs.getBean("service");
	 
		service1.save();
	}
	
	 
}
