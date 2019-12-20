package com.bdqn.test;
 
 
import com.bdqn.dao.UserDao;
import com.bdqn.service.UserService;
import com.bdqn.util.ApplicationContext;

public class UserTest {

	
	public static void main(String[] args) {
		 
		ApplicationContext ac = new ApplicationContext();
		UserDao userdao = (UserDao) ac.getBean("userdao");
		UserService service = (UserService) ac.getBean("userservice");
		System.out.println(service);
		
	}
	
	 
}
