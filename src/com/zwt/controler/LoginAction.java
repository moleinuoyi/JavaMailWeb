package com.zwt.controler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zwt.modle.User;
import com.zwt.service.MailService;
import com.zwt.service.impl.UserServiceImpl;

public class LoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String yanzhengma;
	
	UserServiceImpl userservice;
	private MailService mailservice;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public MailService getMailservice() {
		return mailservice;
	}
	public void setMailservice(MailService mailservice) {
		this.mailservice = mailservice;
	}
	
	
	public String execute() throws Exception{
		// TODO Auto-generated method stub
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		String sessionCode = session.getAttribute("code").toString();
		
		if(yanzhengma.equals(sessionCode)) {
			username.replace(" ", "");
			if(!username.endsWith("@zwt.com")) {
				username = username+"@zwt.com";
			}
			
			if(userservice.checkLogin(username,password)) {
				User user = userservice.findUserByMailName(username);
				session.setAttribute("user", user);
				session.setAttribute("Locals",mailservice.findMailLocalByUserId(user.getId().toString()));
				session.setAttribute("Status",mailservice.findMailStatusByUserId(user.getId().toString()));
				if(user.getRegisteStatu() == 0) {
					return INPUT;
				}else {
					return SUCCESS;
				}
			}else {
				session.setAttribute("errorLogin","用户名或密码错误！");
				return ERROR;
			}
		}else {
			session.setAttribute("errorLogin","验证码错误！");
			return ERROR;
		}
	}
	
	
	
}
