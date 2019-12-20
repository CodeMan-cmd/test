package com.bdqn.dao;

import org.springframework.stereotype.Repository;



@Repository
public class UserDao {

	
	public int save(){
		System.out.println("保存到数据库");
		return 1;
	}
}
