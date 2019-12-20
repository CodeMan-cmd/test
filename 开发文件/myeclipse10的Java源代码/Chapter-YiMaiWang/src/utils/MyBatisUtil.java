package utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	// ����SqlSessionFactory����,�˶��������ɶ������ļ��Ķ�ȡ
	private static SqlSessionFactory factory;
	static {
		// �ھ�̬�������,factoryֻ�ᱻ����һ��
		try {
			// ��ȡmybatis-config.xml�ļ���������
			InputStream is = Resources
					.getResourceAsStream("mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ����SqlSession����,�˶���������ǵ���mapper�ļ��������ݲ���,��Ҫע����Ǳ����Ȱ�maper�ļ����뵽mybatis-config.xml�в�����Ч
	public static SqlSession createSqlSession() {
		return factory.openSession(false);// trueΪ�Զ��ύ����
	}

	// �ر�SqlSession����
	public static void closeSqlSession(SqlSession sqlSession) {
		if (null != sqlSession) {
			sqlSession.close();
		}
	}
}
