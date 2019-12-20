package service;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.UserMapper;
import pojo.User;
import util.Page;
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper  userMapper;
	public UserMapper getUserDao() {
		return userMapper;
	}
	public void setUserDao(UserMapper userDao) {
		this.userMapper = userDao;
	}
	public int addUser(User u) {
		// TODO Auto-generated method stub
		return userMapper.addUser(u);
	}
	
	public List<User> selectByPR(User u, Page p) {
		//System.out.println(selectCountByUser(u)+"111111111111111111111111");
		p.setZongjilushu(selectCountByUser(u));
		return userMapper.selectByPR(u, p);
	}
	public int selectCountByUser(User u) {
		// TODO Auto-generated method stub
		return userMapper.selectCountByUser(u);
	}
	public List<User> selectById(int id) {
		// TODO Auto-generated method stub
		return userMapper.selectById(id);
	}
	public int modifyUserSave(User u) {
		// TODO Auto-generated method stub
		return userMapper.modifyUserSave(u);
	}
	public List<User> resUserCode(String userCode) {
		// TODO Auto-generated method stub
		return userMapper.resUserCode(userCode);
	}
}
