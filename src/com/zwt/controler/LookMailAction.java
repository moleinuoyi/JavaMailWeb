package com.zwt.controler;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zwt.modle.Mail_Receive;
import com.zwt.service.MailService;

public class LookMailAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MailService mailservice;
	private String mailId;//µ±Ç°ÓÊ¼þid
	
	public MailService getMailservice() {
		return mailservice;
	}
	public void setMailservice(MailService mailservice) {
		this.mailservice = mailservice;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		Mail_Receive mail_r = mailservice.findMailByMailId(mailId);
		if(mail_r.getStatus()!=2) {
			mail_r.setStatus(2);
			if(!mailservice.replaceMail_ReceiveStatus(mail_r)) {
				return ERROR;
			}
		}
		request.setAttribute("mail", mail_r);
		return SUCCESS;
	}
}
