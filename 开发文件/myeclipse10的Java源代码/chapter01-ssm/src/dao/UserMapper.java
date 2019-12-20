package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.User;
import util.Page;

public interface UserMapper {

	public int addUser(@Param("u") User u);
	/**
	 * 动态查询     分页   两条件
	 * @param u  用户信息对象
	 * @param p	 分页工具对象
	 * @return 用户信息的集合
	 */
	public List<User> selectByPR(@Param("u")User u,@Param("p")Page p);
	
	
	public int selectCountByUser(@Param("u")User u);
	
	public List<User> selectById(int id);
	
	public int modifyUserSave(@Param("u") User u);
	
	public List<User> resUserCode(@Param("uc") String userCode);
	
}
