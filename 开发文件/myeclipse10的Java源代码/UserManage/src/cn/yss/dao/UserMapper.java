package cn.yss.dao;

import java.util.List;

import cn.yss.entity.User;

public interface UserMapper {
	// 查询所有用户信息
	public List<User> selectAllUser(User user);

	// 增加新用户
	public int addUser(User user);

	// 根据id查询用户
	public User getUserById(int id);

	// 更新用户信息
	public int updateUser(User user);

	// 删除
	public int deleteUser(int id);
}
