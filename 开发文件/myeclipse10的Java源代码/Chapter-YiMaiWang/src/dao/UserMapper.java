package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.User;
import util.Page;

public interface UserMapper {
	//添加
	public List<User> insertUser(@Param("i") User i);
	//删除
	public int deleteUser(@Param("d") int d );
	//该
	public int updateUser(@Param("u") User u);
	//查询
	public List<User> selectUser();
	/***
	 * 求和
	 * LIMIT求值
	 * @return
	 */
	//查询总记录数
	public int selectCount();
	//LIMIT查询
	public List<User> selectLimit(@Param("l") Page l);
}
