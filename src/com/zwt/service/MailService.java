package com.zwt.service;

import java.util.List;

import com.zwt.modle.Local;
import com.zwt.modle.Mail_Receive;
import com.zwt.modle.Mail_Send;
import com.zwt.modle.Result;
import com.zwt.modle.Status;
import com.zwt.util.Page;

public interface MailService {
	public boolean addMail_Receive(Mail_Receive mail);
	public boolean addMail_Send(Mail_Send mail);
	
	public Mail_Receive findMailByMailId(String mailId);
	public List<Mail_Receive> findMailByUserName(String userName);
	public Result findMailByUserName_Commons_FenYe(String mailName,Page page,int localid);
	
	public boolean replaceMail_ReceiveStatus(Mail_Receive mail);
	
	public List<Local> findMailLocalByUserId(String userId);
	public List<Status> findMailStatusByUserId(String userId);
}
