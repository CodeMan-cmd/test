package com.bdqn.service;

import java.util.Date;

import com.bdqn.dao.UserDao;

public class UserService {
	
	 public UserService(String username,Date date){
		 
		 this.username = username;
		 this.date = date;
		 
	 }
	 
	 public UserService(String username,UserDao
			  userdao){
		 this.userdao = userdao;
		 this.username = username;
		 
		 
	 }
	
	
	private String username;
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
	
	private Date date;
	private UserDao userdao;// = new UserDao();
	 
	public void destory(){
		System.out.println("¶ÔÏóÃğÍöÁË");
		
	}
	 
	public void save(){
		userdao.save();
		System.out.println(date);
	}
}
 