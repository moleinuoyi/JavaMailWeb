package com.zwt.service.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import com.zwt.dao.impl.UserDaoImpl;
import com.zwt.modle.User;
import com.zwt.service.UserService;
import com.zwt.util.CryptographyUtil;

public class UserServiceImpl implements UserService{

	private UserDaoImpl userdao;
	
	public UserDaoImpl getUserdao() {
		return userdao;
	}
	public void setUserdao(UserDaoImpl userdao) {
		this.userdao = userdao;
	}

	@Override
	public boolean addUser(User user) {
		return userdao.insertUser(user);
	}

	@Override
	public User findUserByMailName(String mailName) {
		return userdao.selectUserByMailName(mailName);
	}
	@Override
	public boolean replaceUser(User user) {
		// TODO Auto-generated method stub
		return userdao.updateUser(user);
	}
	
	@Override
	public boolean checkUserByMailName(String mailName) {
		if(userdao.selectUserByMailName(mailName)!=null) {
			return true;
		}else {
			return false;
		}
	}
//µÇÂ¼
	@SuppressWarnings("unused")
	@Override
	public boolean checkLogin(String userName, String password) {
		// TODO Auto-generated method stub
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(userName, CryptographyUtil.md5(password, "zwt.com"));
		try{
//			if(subject.isRemembered()){
//				System.out.println("---isRememberMe---");
//			}else{
//				token.setRememberMe(true);				
//			}
			subject.login(token);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	
}
