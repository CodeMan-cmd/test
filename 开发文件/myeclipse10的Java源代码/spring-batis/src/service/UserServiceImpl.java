package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import pojo.User;
import util.Page;

import dao.UserMapper;

@Repository("userService")
public class UserServiceImpl implements UserService {
	@Resource
	public UserMapper userMapper;

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

	/**
	 * 查询所有分页显示
	 */
	public List<User> getAllUser(User u, Page p) {
		// 保存总计录数
		p.setZongjilushu(getCountUser(u));
		System.out.println(getCountUser(u) + "aaaaa");

		return userMapper.getAllUser(u, p);
	}

	// 查询总记录数
	public int getCountUser(User u) {
		// 查询多少条数据
		return userMapper.getCountUser(u);
	}
	//根据id更新
	public int updateUser(User u) {
		return userMapper.updateUser(u);
	}
	//根据id查询
	public List<User> selectById(int id) {
		return userMapper.selectById(id);
	}
	//添加
	public int insertUser(User i) {
		return userMapper.insertUser(i);
	}
	//删除

	public int dateUser(int id) {
		return userMapper.dateUser(id);
	}
	//查詢出userCode
	public List<User> resUserCode(String userCode) {
		return userMapper.resUserCode(userCode);
	}
	
}
