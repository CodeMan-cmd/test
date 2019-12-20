package service;

import java.util.List;

import pojo.User;
import util.Page;

public interface UserService {

	/**
	 * 查询所有
	 * 
	 * @return user对象
	 */
	List<User> getAllUser(User u, Page p);

	/**
	 * 查询总记录数
	 * 
	 * @return 总记录数 (int)
	 */
	int getCountUser(User u);

	/***
	 * 更新
	 * 
	 * @param u
	 * @return
	 */
	public int updateUser(User u);

	/***
	 * 根据id查询
	 * 
	 * @param u
	 * @return
	 */
	public List<User> selectById(int id);
	/***
	 * 添加
	 * @param d
	 * @return
	 */
	public int insertUser(User i);
	/***
	 * 删除
	 * @param id
	 * @return
	 */
	public int dateUser(int id);
	/***
	 * jsion
	 * @param userCode
	 * @return
	 */
	public List<User> resUserCode(String userCode);
}
