package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.User;
import util.Page;

public interface UserMapper {

	public int addUser(@Param("u") User u);
	/**
	 * ��̬��ѯ     ��ҳ   ������
	 * @param u  �û���Ϣ����
	 * @param p	 ��ҳ���߶���
	 * @return �û���Ϣ�ļ���
	 */
	public List<User> selectByPR(@Param("u")User u,@Param("p")Page p);
	
	
	public int selectCountByUser(@Param("u")User u);
	
	public List<User> selectById(int id);
	
	public int modifyUserSave(@Param("u") User u);
	
	public List<User> resUserCode(@Param("uc") String userCode);
	
}
