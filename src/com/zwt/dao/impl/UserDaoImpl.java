package com.zwt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zwt.dao.UserDao;
import com.zwt.modle.User;

public class UserDaoImpl extends HibernateDaoSupport{
	public User getByUserName(Connection con,String userName) throws SQLException {
		User resultUser = null;
		String sql = "select * from t_user where userNamer=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, userName);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			resultUser = new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUsername(rs.getString("userNamer"));
			resultUser.setPassword(rs.getString("password"));
		}
		return resultUser;
		
	}

	public Set<String> getRoles(Connection con, String userName) throws SQLException {
		// TODO Auto-generated method stub
		Set<String> roles = new HashSet<String>();
		String sql = "select * from t_user u,t_role r where u.roleId=r.id and u.userNamer= ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, userName);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			roles.add(rs.getString("roleName"));
		}
		return roles;
	}

	public Set<String> getPermissions(Connection con, String userName) throws SQLException {
		// TODO Auto-generated method stub
		Set<String> permissions = new HashSet<String>();
		String sql = "select * from t_user u,t_role r,t_parmissiom p where u.roleId=r.id and p.roleId=r.id and u.userNamer= ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, userName);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			permissions.add(rs.getString("permissionName"));
		}
		return permissions;
	}
}
