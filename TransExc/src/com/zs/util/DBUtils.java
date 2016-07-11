package com.zs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtils {
	
	public static Connection openDB() throws SQLException, ClassNotFoundException{
		Connection con=null;
		
		/*
		 *2016年7月7日17:16:11
		 *张顺
		 *sql server 
		 
		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=family","sa","sa");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		* */
		
		
		
		/*
		 *2016年7月7日17:16:11
		 *张顺
		 *mysql 
		 * */
		String url="jdbc:mysql://localhost:3306/zs_test?user=root&password=123456";
		Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
		con = DriverManager.getConnection(url);
		
		return con;
	}
	
	
}