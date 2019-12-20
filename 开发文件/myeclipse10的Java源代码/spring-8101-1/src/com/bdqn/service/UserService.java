package com.bdqn.service;

import com.bdqn.dao.UserDao;

public class UserService {
	
	
	
	
	private String username;
	
	

	private UserDao userdao;// = new UserDao();
	
	
	
 
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public void setYyy(UserDao dao){
		
		this.userdao = dao;
	}
	
	
	public void destory(){
		System.out.println("¶ÔÏóÃğÍöÁË");
		
	}
	
	
	
	
	
	public void save(){
		userdao.save();
	}
}
 