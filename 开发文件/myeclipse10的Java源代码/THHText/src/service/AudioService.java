package service;
import java.util.List;
import dao.AudioDao;
import entity.Audio;

public class AudioService {
			AudioDao dao=new AudioDao();
			// 查询
			public List<Audio> getAllPerson() {
				return dao.getAllPerson();
			}

			// 根据id查询
			public Audio getByuserId(int id) {
				return dao.getByuserId(id);
			}
			//登陆
			public boolean isExists(String user,String pwd) {
				return dao.isExists(user, pwd);
			}
			//添加
			public int addProduct(Audio p) {
				return dao.addProduct(p);
			}

			// 删除
			public int deletePerson(int id) {
				return dao.deletePerson(id);
			}
			//修改
			public int updatePerson(Audio p) {
				return dao.updatePerson(p);
			}
			
}
