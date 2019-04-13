package com.zwt.dao;

import java.util.List;

import com.zwt.modle.Local;
import com.zwt.modle.Mail_Receive;
import com.zwt.modle.Mail_Send;
import com.zwt.modle.Status;
import com.zwt.util.Page;

public interface MailDao {
	public boolean insertMail_Receive(Mail_Receive mail);
	public boolean insertMail_Send(Mail_Send mail);
	
	public Mail_Receive selectMailByMailId(String mailId);
	public List<Mail_Receive> selectMailByUserName(String userName);
	public int selectMailAllCount(String mailName);
	public List<Mail_Receive> selectMailByMailName_Commons_FenYe(String userName,Page page,int localid);
	
	public List<Local> selectMail_Local(String userId);
	public List<Status> selectMail_Status(String userId);
	
	public boolean updateMail_Receive(Mail_Receive mail);
	public boolean deleteMail_Receive(Mail_Receive mail);
}
