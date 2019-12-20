package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {
	public Connection getconn(){
		Connection conn=null;
		try {
			Class.forName("com.mysql,jdbc.Driver");
			try {
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/petshop","root","123456");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
		return conn;
	}
	//关闭
	public void CloseAll(ResultSet rs,Statement stmt,Connection conn){	
			try {
				if(rs!=null)
				rs.close();
				if(stmt!=null)
					stmt.close();
				if (conn!=null) 
					conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}
	//增删改
	public int updataeAll(String sql,Object[] prams){
		int num=-1;
		Connection conn=getconn();
		PreparedStatement ps=null;
	try {
		 ps=conn.prepareStatement(sql);
		 for (int i = 0; i < prams.length; i++) {
			ps.setObject(i+1,prams[i]);
		}
		 num=ps.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		CloseAll(null, ps, conn);
	}
		return num;	
	}
	
	//查询
	public ResultSet selectAll(String sql,Object[] prams){
		ResultSet rs=null;
		Connection conn=getconn();
		PreparedStatement ps=null;
	try {
		 ps=conn.prepareStatement(sql);
		 for (int i = 0; i < prams.length; i++) {
			ps.setObject(i+1,prams[i]);
		}
		rs=ps.executeQuery();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		CloseAll(rs, ps, conn);
	}
		return rs;	
	}	
}
