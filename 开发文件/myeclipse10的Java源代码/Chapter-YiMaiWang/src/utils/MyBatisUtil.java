package utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	// 创建SqlSessionFactory对象,此对象可以完成对配置文件的读取
	private static SqlSessionFactory factory;
	static {
		// 在静态代码块下,factory只会被创建一次
		try {
			// 获取mybatis-config.xml文件的输入流
			InputStream is = Resources
					.getResourceAsStream("mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 创建SqlSession对象,此对象的作用是调用mapper文件进行数据操作,需要注意的是必须先把maper文件引入到mybatis-config.xml中才能起效
	public static SqlSession createSqlSession() {
		return factory.openSession(false);// true为自动提交事务
	}

	// 关闭SqlSession对象
	public static void closeSqlSession(SqlSession sqlSession) {
		if (null != sqlSession) {
			sqlSession.close();
		}
	}
}
