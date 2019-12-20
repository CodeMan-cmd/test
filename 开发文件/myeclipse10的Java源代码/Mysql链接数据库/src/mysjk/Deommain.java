package mysjk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Deommain {
public static void main(String[] args){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysjk","root","123456");
			Statement stmt=conn.createStatement();
			String sql="SELECT  id,username,pwd FROM psent;";
			//这是executeQuery是查
			ResultSet rs=stmt.executeQuery(sql);
			while (rs.next()) {
				int id=rs.getInt(1);
				String username=rs.getString(2);
				String password=rs.getString(3);
				
				System.out.println(id+username+password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
}
