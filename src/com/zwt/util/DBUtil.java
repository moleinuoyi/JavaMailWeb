package com.zwt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.zwt.dao.impl.UserDaoImpl;
import com.zwt.modle.User;

public class DBUtil {

	public static Connection getCon() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javamailweb?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root", "root");
		return con;
	}
	public static void closeCon(Connection con)throws Exception{
		if(con!=null){
			con.close();
		}
	}
	public static void main(String[] args) {
		Connection con = null;
		try {
			con = DBUtil.getCon();
			
			String userName="zjj@zwt.com";
			UserDaoImpl user = new UserDaoImpl();
			user.getByUserName(con, userName);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error");
		}
		try {
			DBUtil.closeCon(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
