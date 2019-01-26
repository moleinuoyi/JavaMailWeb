package com.zwt.controler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	private String username;
	private String password;
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
	public String execute() throws Exception{
		// TODO Auto-generated method stub
		System.out.println(username+" !!! "+password);
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		try {
			subject.login(token);
		}catch(Exception e) {
			e.printStackTrace();
			session.setAttribute("errorLogin", "用户名或密码错误!");
			return ERROR;
		}
		return SUCCESS;
	}
	
	
}
