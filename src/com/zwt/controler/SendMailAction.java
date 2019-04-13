package com.zwt.controler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zwt.modle.Mail_Receive;
import com.zwt.modle.Mail_Send;
import com.zwt.modle.User;
import com.zwt.service.MailService;

public class SendMailAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String sendTo;
	private String title;
	private String content;
	
	MailService mailservice;
	
	public String getSendTo() {
		return sendTo;
	}
	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public MailService getMailservice() {
		return mailservice;
	}
	public void setMailservice(MailService mailservice) {
		this.mailservice = mailservice;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		System.out.println(title);
		System.out.println(content);
		System.out.println(sendTo);
		
		
		User user = (User)session.getAttribute("user");
		Mail_Send mail_s = new Mail_Send();
		
		Date now = new Date();
		java.sql.Date sendTime = new java.sql.Date(now.getTime());
		mail_s.setMailTitle(title);
		mail_s.setMailContent(content);
		mail_s.setSendPeople(user.getMailName());
		mail_s.setReceivePeople(sendTo);
		mail_s.setDateTime(sendTime);
		mail_s.setIsStar(0);
		mail_s.setStatus(1);
		mail_s.setLocal(2);
		mailservice.addMail_Send(mail_s);
		
		Mail_Receive mail_r = new Mail_Receive();
		mail_r.setMailTitle(title);
		mail_r.setMailContent(content);
		mail_r.setSendPeople(user.getMailName());
		mail_r.setReceivePeople(sendTo);
		mail_r.setDateTime(sendTime);
		mail_r.setNature("private");
		mail_r.setIsStar(0);
		mail_r.setStatus(3);
		mail_r.setLocal(1);
		mailservice.addMail_Receive(mail_r);
		
		return SUCCESS;
	}
	public String saveDraft() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		Mail_Send mail_s = new Mail_Send();
		
		Date now = new Date();
		java.sql.Date sendTime = new java.sql.Date(now.getTime());
		Mail_Receive mail_r = new Mail_Receive();
		mail_r.setMailTitle(title);
		mail_r.setMailContent(content);
		mail_r.setSendPeople(user.getMailName());
		mail_r.setReceivePeople(sendTo);
		mail_r.setDateTime(sendTime);
		mail_r.setNature("private");
		mail_r.setIsStar(0);
		mail_r.setStatus(3);
		mail_r.setLocal(3);
		mailservice.addMail_Receive(mail_r);
		return SUCCESS;
	}
}
