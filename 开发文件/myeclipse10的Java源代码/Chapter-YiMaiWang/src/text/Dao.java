package text;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.UserMapper;

import pojo.User;
import util.Page;
import utils.MyBatisUtil;

public class Dao {
	//添加
	public List<User> insertUser(User i) {
		SqlSession session = null;
		session = MyBatisUtil.createSqlSession();
		List<User> i1=session.getMapper(UserMapper.class).insertUser(i);
		return i1;
	}
	//删除
	public int deleteUser(int d) {
		SqlSession session = null;
		session = MyBatisUtil.createSqlSession();
		int i1=session.getMapper(UserMapper.class).deleteUser(d);
		return i1;
	}
	//修改
	public int updateUser(User u) {
		SqlSession session = null;
		session = MyBatisUtil.createSqlSession();
		int i1=session.getMapper(UserMapper.class).updateUser(u);
		return i1;
		
	}
	//查询
	public List<User> selectUser() {
		SqlSession session = null;
		session = MyBatisUtil.createSqlSession();
		List<User> i1=session.getMapper(UserMapper.class).selectUser();
		return i1;
	}
	//LIMIT查询
	public List<User> selectLimit(){
		SqlSession session = null;
		session = MyBatisUtil.createSqlSession();
		int i=session.getMapper(UserMapper.class).selectCount();
		Page l=new Page();
		l.setZongjiluhsu(i);
		List<User> selectPage=session.getMapper(UserMapper.class).selectLimit(l);
		return selectPage;
	}

}
