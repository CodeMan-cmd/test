package com.qingniao.sso.service;


import com.qingniao.common.pojo.QingNiaoResult;
import com.qingniao.pojo.TbUser;

public interface UserService {

	
	public QingNiaoResult checkParam(String param,int type);
	public QingNiaoResult registor(TbUser user);
	
	public QingNiaoResult login(TbUser user);
	public QingNiaoResult getUserByToken( String ticket);
}
