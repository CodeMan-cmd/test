package text;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.UserMapper;

import pojo.User;
import util.Page;
import utils.MyBatisUtil;

public class Dao {
	//���
	public List<User> insertUser(User i) {
		SqlSession session = null;
		session = MyBatisUtil.createSqlSession();
		List<User> i1=session.getMapper(UserMapper.class).insertUser(i);
		return i1;
	}
	//ɾ��
	public int deleteUser(int d) {
		SqlSession session = null;
		session = MyBatisUtil.createSqlSession();
		int i1=session.getMapper(UserMapper.class).deleteUser(d);
		return i1;
	}
	//�޸�
	public int updateUser(User u) {
		SqlSession session = null;
		session = MyBatisUtil.createSqlSession();
		int i1=session.getMapper(UserMapper.class).updateUser(u);
		return i1;
		
	}
	//��ѯ
	public List<User> selectUser() {
		SqlSession session = null;
		session = MyBatisUtil.createSqlSession();
		List<User> i1=session.getMapper(UserMapper.class).selectUser();
		return i1;
	}
	//LIMIT��ѯ
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
