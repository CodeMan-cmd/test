package service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.User;
import util.Page;
/**
 * 业务逻辑层
 * @author huohongyan
 *
 */
public interface UserService {

	
	public int addUser(User u);
	/**
	 * 动态查询     分页   两条件
	 * @param u  用户信息对象
	 * @param p	 分页工具对象
	 * @return 用户信息的集合
	 */
	public List<User> selectByPR(User u,Page p);
	public int selectCountByUser(User u);
	public List<User> selectById(int id);
	public int modifyUserSave(User u);
	public List<User> resUserCode(String userCode);
}
