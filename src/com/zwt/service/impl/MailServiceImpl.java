package com.zwt.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.zwt.dao.impl.MailDaoImpl;
import com.zwt.modle.Local;
import com.zwt.modle.Mail_Receive;
import com.zwt.modle.Mail_Send;
import com.zwt.modle.Result;
import com.zwt.modle.Status;
import com.zwt.service.MailService;
import com.zwt.util.Page;
import com.zwt.util.PageUtil;

public class MailServiceImpl implements MailService {

	private MailDaoImpl maildao;
	public MailDaoImpl getMaildao() {
		return maildao;
	}
	public void setMaildao(MailDaoImpl maildao) {
		this.maildao = maildao;
	}

	@Override
	public boolean addMail_Receive(Mail_Receive mail) {
		// TODO Auto-generated method stub
		return maildao.insertMail_Receive(mail);
	}

	@Override
	public boolean addMail_Send(Mail_Send mail) {
		// TODO Auto-generated method stub
		return maildao.insertMail_Send(mail);
	}
	@Override
	public List<Mail_Receive> findMailByUserName(String mailName) {
		// TODO Auto-generated method stub
		return maildao.selectMailByUserName(mailName);
	}
	@Override
	public Result findMailByUserName_Commons_FenYe(String mailName, Page page,int localid) {
		// TODO Auto-generated method stub
		page = PageUtil.createPage(page, maildao.selectMailAllCount(mailName));
		Result resule = new Result();
		resule.setPage(page);
		resule.setList(maildao.selectMailByMailName_Commons_FenYe(mailName, page,localid));
		return resule;
	}
	@Override
	public List<Local> findMailLocalByUserId(String userId) {
		// TODO Auto-generated method stub
		return maildao.selectMail_Local(userId);
	}
	@Override
	public List<Status> findMailStatusByUserId(String userId) {
		// TODO Auto-generated method stub
		return maildao.selectMail_Status(userId);
	}
	@Override
	public Mail_Receive findMailByMailId(String mailId) {
		// TODO Auto-generated method stub
		return maildao.selectMailByMailId(mailId);
	}
	@Override
	public boolean replaceMail_ReceiveStatus(Mail_Receive mail) {
		// TODO Auto-generated method stub
		return maildao.updateMail_Receive(mail);
	}
	@Override
	public boolean replaceMail_ReceiveLocal(Mail_Receive mail) {
		// TODO Auto-generated method stub
		return maildao.updateMail_Receive(mail);
	}

}
