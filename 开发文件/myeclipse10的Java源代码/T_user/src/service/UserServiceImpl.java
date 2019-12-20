package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pojo.User;

import dao.UserMapper;
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper mapper;

	public List<User> selectAllUser(User user) {
		// 查询用户
		return mapper.selectAllUser(user);
	}

	public int addUser(User user) {
		// 增加新用
		return mapper.addUser(user);
	}

	public User getUserById(int id) {
		// 根据id查询
		return mapper.getUserById(id);
	}

	public int updateUser(User user) {
		// 更新用户信息
		return mapper.updateUser(user);
	}

	public int deleteUser(int id) {
		// 删除用户
		return mapper.deleteUser(id);
	}

}
