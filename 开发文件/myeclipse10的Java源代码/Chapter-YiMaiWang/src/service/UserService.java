package service;

import java.util.List;
import pojo.User;
import text.Dao;

public class UserService {
		Dao dao=new Dao();
		//���
		public List<User> insertUser(User i) {
			return dao.insertUser(i);
		}
		//ɾ��
		public int deleteUser(int d) {
			return dao.deleteUser(d);
		}
		//�޸�
		public int updateUser(User u) {
			return dao.updateUser(u);
		}
		//��ѯ
		public List<User> selectUser() {
			return dao.selectUser();
		}
		//LIMIT��ѯ
		public List<User> selectLimit(){
			return dao.selectLimit();
		}

}
