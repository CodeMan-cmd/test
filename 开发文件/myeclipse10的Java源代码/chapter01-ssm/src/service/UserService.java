package service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.User;
import util.Page;
/**
 * ҵ���߼���
 * @author huohongyan
 *
 */
public interface UserService {

	
	public int addUser(User u);
	/**
	 * ��̬��ѯ     ��ҳ   ������
	 * @param u  �û���Ϣ����
	 * @param p	 ��ҳ���߶���
	 * @return �û���Ϣ�ļ���
	 */
	public List<User> selectByPR(User u,Page p);
	public int selectCountByUser(User u);
	public List<User> selectById(int id);
	public int modifyUserSave(User u);
	public List<User> resUserCode(String userCode);
}
