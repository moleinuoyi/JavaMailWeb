package com.zwt.realm;

import java.sql.Connection;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.zwt.dao.impl.UserDaoImpl;
import com.zwt.modle.User;
import com.zwt.util.DBUtil;

public class ShiroRealm extends AuthorizingRealm{
	
	private UserDaoImpl userdao = new UserDaoImpl();
	/**
	 * 为当前登录的用户授予角色和权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		String userName = (String)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorization = new SimpleAuthorizationInfo();
		Connection con = null;
		try {
			con = DBUtil.getCon();
			authorization.setRoles(userdao.getRoles(con,userName));
			authorization.setStringPermissions(userdao.getPermissions(con,userName));
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return authorization;
	}
	
	/**
	 * 验证当前登录用户
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String userName = (String)token.getPrincipal();
		System.out.println("登录："+userName);
		Connection con = null;
		try {
			con = DBUtil.getCon();
			User user = userdao.getByUserName(con, userName);
			if(user!=null) {
				AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),"xx");
				return authcInfo;
			}else
				return null;
		}catch(Exception e) {
			e.getStackTrace();
			return null;
		}finally {
			try {
				DBUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
