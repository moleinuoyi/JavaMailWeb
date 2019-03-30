package com.zwt.controler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zwt.modle.Local;
import com.zwt.modle.Mail_Receive;
import com.zwt.modle.Result;
import com.zwt.modle.User;
import com.zwt.service.MailService;
import com.zwt.util.Page;


public class ReadMailAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int currentPage;//当前页面
	private int localId;//当前邮件箱
	private MailService mailservice;
	public MailService getMailservice() {
		return mailservice;
	}
	public void setMailservice(MailService mailservice) {
		this.mailservice = mailservice;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getLocalId() {
		return localId;
	}
	public void setLocalId(int localId) {
		this.localId = localId;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setEveryPage(2);
		
		//List<Mail_Receive> list = mailservice.findMailByUserName(user.getMailName());
		Result result = mailservice.findMailByUserName_Commons_FenYe(user.getMailName(), page,1);
		List<Mail_Receive> list = result.getList();
		
		for (Mail_Receive mail_Receive : list) {
			System.out.println(mail_Receive.getMailTitle());
		}
		request.setAttribute("Page", result.getPage());
		request.setAttribute("MailAll", result.getList());
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String mailcommons() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setEveryPage(2);
		
		//List<Mail_Receive> list = mailservice.findMailByUserName(user.getMailName());
		Result result = mailservice.findMailByUserName_Commons_FenYe(user.getMailName(), page, localId);
		List<Mail_Receive> list = result.getList();
		
		for (Mail_Receive mail_Receive : list) {
			System.out.println(mail_Receive.getMailTitle());
		}
		request.setAttribute("Page", result.getPage());
		request.setAttribute("MailAll", result.getList());
		return SUCCESS;
	}
}
