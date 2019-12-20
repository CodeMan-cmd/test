package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Audio;

public class AudioDao extends BaseDao{
	// 查询
		public List<Audio> getAllPerson() {
			List<Audio> list = new ArrayList<Audio>();
			String sql = "SELECT id,name,music,video,image FROM audio";
			ResultSet rs = getAll(sql, null);
			try {
				while (rs.next()) {
					list.add(new Audio(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		// 根据id查询
		public Audio getByuserId(int id) {
			Audio p = null;
			String sql = "SELECT * FROM  audio WHERE id=?";
			ResultSet rs = getAll(sql, new Object[] { id });
			try {
				if (rs.next()) {//      id         name               music              video         image   
					p = new Audio(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return p;
		}
		//登陆
		public boolean isExists(String user,String pwd) {
			boolean flag = false;
			String sql = "select * from username where user=? and pwd=?";
			ResultSet rs =getAll(sql,new Object[]{user,pwd});
			try {
				if (rs.next()) {
					flag = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}
		//添加
		public int addProduct(Audio p) {
			return updateAll(
					"insert into audio(name,music,video,image)values(?,?,?,?)",
					new Object[] {p.getName(),p.getMusic(),p.getVideo(),p.getImage()});
		}

		// 删除
		public int deletePerson(int id) {
			String sql = "delete from audio where id=?";
			return updateAll(sql, new Object[] { id });
		}
		//修改
		public int updatePerson(Audio p) {
			String sql = "update audio set name=?,music=?,video=?,image=? where id=?";
			Object[] params = new Object[] {p.getName(),p.getMusic(),p.getVideo(),p.getImage(),p.getId()};
			return updateAll(sql, params);
		}
}
