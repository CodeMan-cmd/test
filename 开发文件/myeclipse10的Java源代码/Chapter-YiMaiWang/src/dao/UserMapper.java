package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.User;
import util.Page;

public interface UserMapper {
	//���
	public List<User> insertUser(@Param("i") User i);
	//ɾ��
	public int deleteUser(@Param("d") int d );
	//��
	public int updateUser(@Param("u") User u);
	//��ѯ
	public List<User> selectUser();
	/***
	 * ���
	 * LIMIT��ֵ
	 * @return
	 */
	//��ѯ�ܼ�¼��
	public int selectCount();
	//LIMIT��ѯ
	public List<User> selectLimit(@Param("l") Page l);
}
