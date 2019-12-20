package text;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import pojo.User;
import util.Page;
import utils.MyBatisUtil;
import dao.UserMapper;

public class Text1 {
	public static void main(String[] args) {
		SqlSession session = null;
		session = MyBatisUtil.createSqlSession();
		int i=session.getMapper(UserMapper.class).selectCount();
		Page l=new Page();
		l.setZongjiluhsu(i);
		l.setDangqianyeshu(2);
		List<User> selectPage=session.getMapper(UserMapper.class).selectLimit(l);
		for (User user : selectPage) {
			System.out.println(user.getUserName());
		}
	}
}
