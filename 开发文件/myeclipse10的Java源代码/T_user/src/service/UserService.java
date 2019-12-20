package service;

import java.util.List;

import pojo.User;

public interface UserService {
	// 查询用户信息
	public List<User> selectAllUser(User user);

	// 增加新用户
	public int addUser(User user);

	// 根据id查询
	public User getUserById(int id);

	// 更新用户信息
	public int updateUser(User user);

	// 删除
	public int deleteUser(int id);
}
