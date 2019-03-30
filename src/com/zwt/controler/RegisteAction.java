package com.zwt.controler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zwt.modle.User;
import com.zwt.service.impl.UserServiceImpl;
import com.zwt.util.CryptographyUtil;

public class RegisteAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mailName;
	private String userName;
	private String password;
	private String yanzhengma;
	
	UserServiceImpl userservice;
	
	public String getMailName() {
		return mailName;
	}
	public void setMailName(String mailName) {
		this.mailName = mailName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getYanzhengma() {
		return yanzhengma;
	}
	public void setYanzhengma(String yanzhengma) {
		this.yanzhengma = yanzhengma;
	}
	public UserServiceImpl getUserservice() {
		return userservice;
	}
	public void setUserservice(UserServiceImpl userservice) {
		this.userservice = userservice;
	}
	
	
	@SuppressWarnings("unused")
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		String sessionCode = session.getAttribute("code").toString();
		
		if(yanzhengma.equals(sessionCode)) {
			
			mailName.replace(" ", "");
			if(!mailName.endsWith("@zwt.com")) {
				mailName = mailName+"@zwt.com";
			}
			
			Date now = new Date();
			java.sql.Date registerTime = new java.sql.Date(now.getTime());
			if(userservice.checkUserByMailName(mailName)) {
				session.setAttribute("errorLogin","用户名存在！");
				return ERROR;
			}
			
			User user = new User();
			user.setMailName(mailName);
			user.setUserName(userName);
			user.setPassword(CryptographyUtil.md5(password, "zwt.com"));
			user.setUserImage("image/moren.jpg");
			user.setRegisterTime(registerTime);
			user.setRoleId(1);
			
			if(userservice.addUser(user)) {
				return SUCCESS;
			}else {
				session.setAttribute("errorLogin","注册失败！");
				return ERROR;
			}
		}else {
			session.setAttribute("errorLogin","验证码错误！");
			return ERROR;
		}
		
	}

	
}
