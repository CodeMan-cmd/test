package mysjk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoMysql {
	public static void main(String[] args) {
			
			try {
				try {
					//��������
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				//2.ͨ������������������Ӷ���
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysjk","root","123456");
				//3.ͨ�����Ӷ�����ִ�ж���
				Statement stmt=conn.createStatement();
				//4.sql���
				String sql="INSERT INTO Psent (username, pwd) VALUE ('���ľ�','123')";
				//5.ִ��sql��� �������ɾ�Ĳ��� ����update����
				int	num = stmt.executeUpdate(sql);
				System.out.println(num);
				//�������ɾ���ؾͷ����� ����ͷ��ؼ�
				boolean falg=stmt.execute(sql);
				System.out.println(falg);
			} catch (SQLException e) {
				 e.printStackTrace();
			}
	}
}
