package service;
import java.util.List;
import dao.AudioDao;
import entity.Audio;

public class AudioService {
			AudioDao dao=new AudioDao();
			// ��ѯ
			public List<Audio> getAllPerson() {
				return dao.getAllPerson();
			}

			// ����id��ѯ
			public Audio getByuserId(int id) {
				return dao.getByuserId(id);
			}
			//��½
			public boolean isExists(String user,String pwd) {
				return dao.isExists(user, pwd);
			}
			//���
			public int addProduct(Audio p) {
				return dao.addProduct(p);
			}

			// ɾ��
			public int deletePerson(int id) {
				return dao.deletePerson(id);
			}
			//�޸�
			public int updatePerson(Audio p) {
				return dao.updatePerson(p);
			}
			
}
