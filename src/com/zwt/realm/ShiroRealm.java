package com.zwt.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.zwt.dao.impl.UserDaoImpl;
import com.zwt.modle.User;

public class ShiroRealm extends AuthorizingRealm{
	
	private UserDaoImpl userdao;
	public UserDaoImpl getUserdao() {
		return userdao;
	}
	public void setUserdao(UserDaoImpl userdao) {
		this.userdao = userdao;
	}

	/**
	 * 为当前登录的用户授予角色和权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
//		String userName = (String)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorization = new SimpleAuthorizationInfo();
//		Connection con = null;
//		try {
////			authorization.setRoles(userdao.getRoles(con,userName));
////			authorization.setStringPermissions(userdao.getPermissions(con,userName));
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		return authorization;
	}
	
	/**
	 * 验证当前登录用户
	 */
	@SuppressWarnings("unused")
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String mailName = (String)token.getPrincipal();
		//System.out.println("登录："+mailName);
		User user = userdao.selectUserByMailName(mailName);
		System.out.println(user.getUserName()+"!!!!"+user.getPassword());
		try {
			if(user!=null) {
				AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),"xx");
				return authcInfo;
			}else
				throw new UnknownAccountException();
		}catch(Exception e) {
			e.getStackTrace();
			throw new UnknownAccountException();
		}
	}
}
