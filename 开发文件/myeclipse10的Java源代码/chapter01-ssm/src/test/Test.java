package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.Role;
import pojo.User;
import service.UserService;
import service.UserServiceImpl;
import util.Page;

import dao.UserMapper;




public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(BaseDao.bd);
		
		System.out.println(ConfigManager.getcm());
		
		
		
		
		
		/*ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		User u1=new User();
		u1.setUserName("大大");
		UserService u=(UserService) context.getBean("bbb");
		int addUser = u.addUser(u1);
		if(addUser>0){
			System.out.println("新增成功!!!!!!!!!!!!!!!!");
		}*/
		
	}
}
