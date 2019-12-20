package cn.smbms.dao.user;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.smbms.pojo.User;
public class UserMapperTest {
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		//获取mybatis-config.xml路径
		String resource = "mybatis-config.xml";
		//付sqlsession初始值
		SqlSession sqlSession = null;
		// 获取mybatis-config.xml的输入流
		try {
			//给这个初始值放进这个专门读取resource
			InputStream is = Resources.getResourceAsStream(resource);
			// 2创建SqlSessionFactory对象，完成对配置文件的读取
			SqlSessionFactory factory = new SqlSessionFactoryBuilder()
					.build(is);
			// 3创建sqlSession
			sqlSession = factory.openSession();
			// 4调用mapper文件对数据进行操作,必须将mapper文件引入到mybatis-config.xml中
			List<User>	list=sqlSession.getMapper(UserMapper.class).select();
			for (User user : list) {
				System.out.println(user.getId()+user.getUserCode());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{/*
			sqlSession.close();*/
		}

	}
		/*String resource = "mybatis-config.xml";
		int count = 0;
		SqlSession sqlSession = null;
		// 获取mybatis-config.xml的输入流
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			// 2创建SqlSessionFactory对象，完成对配置文件的读取
			SqlSessionFactory factory = new SqlSessionFactoryBuilder()
					.build(is);
			// 3创建sqlSession
			sqlSession = factory.openSession();
			// 4调用mapper文件对数据进行操作,必须将mapper文件引入到mybatis-config.xml中
			count = sqlSession.selectOne("cn.smbms.dao.user.UserMapper.count");
			logger.debug("UserMapperTest count---> " + count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}

	}
*/
}
