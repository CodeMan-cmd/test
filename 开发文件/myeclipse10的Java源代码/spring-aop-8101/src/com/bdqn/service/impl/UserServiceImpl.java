package com.bdqn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.dao.UserDao;
import com.bdqn.service.UserService;


@Service("service")
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserDao userdao;
 
	
	@Override
	public int save() { 
		//int m = 1/0;
		return userdao.save();
	}
 
	@Override
	public int delete() {
	 
		return 0;
	}



	@Override
	public int update() {
	 
		return 0;
	}

}

 


 
