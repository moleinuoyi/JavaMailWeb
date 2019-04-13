package com.zwt.controler;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zwt.modle.Mail_Receive;
import com.zwt.service.MailService;

public class DeleteMailAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String mailId;
	
	private MailService mailservice;
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
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
		Mail_Receive mail_r = mailservice.findMailByMailId(mailId);
		mail_r.setLocal(4);
		return SUCCESS;
	}
	
	public String removeCleanMail() throws Exception {
		
		return SUCCESS;
	}

}
