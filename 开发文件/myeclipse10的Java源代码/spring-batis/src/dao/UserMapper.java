package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import pojo.User;
import util.Page;

@Repository("userMapper")
public interface UserMapper {
	/**
	 * 查询所有
	 * 
	 * @return user对象
	 */
	List<User> getAllUser(@Param("u") User u, @Param("p") Page p);
	/**
	 * 查询总记录数
	 * 
	 * @return 总记录数 (int)
	 */
	int getCountUser(@Param("u") User u);
	/***
	 * 根据查询id
	 * 
	 * @param u
	 * @return
	 */
	public List<User> selectById( int id);
	/***
	 * 更新
	 * 
	 * @param u
	 * @return
	 */
	public int updateUser(@Param("u") User u);
	/***
	 * 添加
	 * 
	 * @return
	 */
	public int insertUser(@Param("i")User i);
	/***
	 * 删除
	 * @param id
	 * @return
	 */
	public int dateUser(int id);
	/***
	 *查詢出userCode
	 * @param userCode
	 * @return
	 */
	public List<User> resUserCode(@Param("u")String userCode);
}
