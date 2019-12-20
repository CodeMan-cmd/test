package com.qingniao.sso.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.qingniao.common.pojo.QingNiaoResult;
import com.qingniao.common.utils.JsonUtils;
import com.qingniao.jedis.JedisClient;
import com.qingniao.mapper.TbUserMapper;
import com.qingniao.pojo.TbUser;
import com.qingniao.pojo.TbUserExample;
import com.qingniao.pojo.TbUserExample.Criteria;
import com.qingniao.sso.service.UserService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

	@Autowired
	private TbUserMapper userMapper;
	
	@Autowired
	private JedisClient jedisClient;
	
	
	@Value("${USER_INFO}")
	private String USER_INFO;
	@Value("${USER_INFO_EXPIRE}")
	private int USER_INFO_EXPIRE;

	@Override
	public QingNiaoResult checkParam(String param, int type) {

		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();

		if (type == 1) {
			criteria.andUsernameEqualTo(param);
			List<TbUser> lists = userMapper.selectByExample(example);
			if (lists.size() > 0) {
				return QingNiaoResult.ok(false);
			}
		} else if (type == 2) {
			criteria.andPhoneEqualTo(param);
			List<TbUser> lists = userMapper.selectByExample(example);
			if (lists.size() > 0) {
				return QingNiaoResult.ok(false);
			}
		} else if (type == 3) {
			criteria.andEmailEqualTo(param);
			List<TbUser> lists = userMapper.selectByExample(example);
			if (lists.size() > 0) {
				return QingNiaoResult.ok(false);
			}
		} else {
			return QingNiaoResult.build(400, "非法参数");
		}
		return QingNiaoResult.ok(true);
	}

	@Override
	public QingNiaoResult registor(TbUser user) {

		String pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		user.setPassword(pass);
		user.setCreated(new Date());
		user.setUpdated(new Date());

		userMapper.insert(user);
		return QingNiaoResult.ok();
	}

	@Override
	public QingNiaoResult login(TbUser user) {
		
		
		String token = UUID.randomUUID().toString();
		
		
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(user.getUsername());
		List<TbUser> lists = userMapper.selectByExample(example);
		if(lists==null||lists.size() == 0){
			return QingNiaoResult.build(400, "用户名不存在");
		}
		TbUser userTemp = lists.get(0);
		String pass  = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		if(!pass.equals(userTemp.getPassword())){
			return QingNiaoResult.build(400, "密码错误");
		}
		
		//把用户存入redis
		userTemp.setPassword("");
		jedisClient.set(USER_INFO+":"+token, JsonUtils.objectToJson(userTemp));
		jedisClient.expire(USER_INFO+":"+token, USER_INFO_EXPIRE);
		return QingNiaoResult.ok(token);
	}

	@Override
	public QingNiaoResult getUserByToken(String ticket) {
		
		String str = jedisClient.get(USER_INFO+":"+ticket);
		TbUser user = null;
		if(StringUtils.isNotBlank(str)){
			user = JsonUtils.jsonToPojo(str, TbUser.class);
			jedisClient.expire(USER_INFO + ":" + ticket, USER_INFO_EXPIRE);
			return QingNiaoResult.ok(user);
		}else{
			return QingNiaoResult.build(400, "用户登录已过期，请重新登录");
		} 
	}

}
