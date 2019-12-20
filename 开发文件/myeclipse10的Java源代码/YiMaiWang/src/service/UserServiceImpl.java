package service;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

import pojo.Easybuy_user;
import dao.UserMapper;
@Repository("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	
	public UserServiceImpl() {
		super();
	}
	public UserServiceImpl(UserMapper userMapper) {
		super();
		this.userMapper = userMapper;
	}
	public UserMapper getUserMapper() {
		return userMapper;
	}
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	//异步判断
	public List<Easybuy_user> selectJudgment(String loginName) {
		return userMapper.selectJudgment(loginName);
	}
	//登录判断
	public List<Easybuy_user> selectUser(String loginName, String password) {
		return userMapper.selectUser(loginName, password);
	}
	//添加
	public int insertUser(Easybuy_user user) {
		return userMapper.insertUser(user);
	}
}
