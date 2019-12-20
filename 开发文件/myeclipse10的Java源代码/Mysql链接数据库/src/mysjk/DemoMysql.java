package mysjk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoMysql {
	public static void main(String[] args) {
			
			try {
				try {
					//加载驱动
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				//2.通过驱动管理器获得链接对象
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysjk","root","123456");
				//3.通过链接对象获得执行对象
				Statement stmt=conn.createStatement();
				//4.sql语句
				String sql="INSERT INTO Psent (username, pwd) VALUE ('何文静','123')";
				//5.执行sql语句 如果是增删改操作 调用update方法
				int	num = stmt.executeUpdate(sql);
				System.out.println(num);
				//如果是增删改呢就返回真 ，查就返回假
				boolean falg=stmt.execute(sql);
				System.out.println(falg);
			} catch (SQLException e) {
				 e.printStackTrace();
			}
	}
}
