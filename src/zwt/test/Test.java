package zwt.test;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//收件人地址
		String to = "2598283973@qq.com";
		//发件人地址
		String from = "test@zwt.com";
		//发件人账户
		String senderAccount = "test@zwt.com";
		//发件人密码
		String senderPassword = "123321";
		//发送主机
		String host = "192.168.56.1";
		
		Properties properties = System.getProperties();
		
		properties.setProperty("mail.smtp.auth", "true");//设置用户的认证方式
		properties.setProperty("mail.transport.protocol", "smtp");//设置传输协议
		properties.setProperty("mail.smtp.port", "25"); 		// 设置smtp端口 
//		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.host", host);			//设置发件人的SMTP服务器地址
		properties.put("mail.smtp.ssl.enable", "true"); 		// 设置是否使用ssl安全连接 ---一般都使用
		try {
			
			Session session = Session.getDefaultInstance(properties);
			session.setDebug(true);
			Transport transport = session.getTransport();//通过session得到transport对象
			//3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
			transport.connect(senderAccount, senderPassword);
			
			MimeMessage message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(from));
			
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			message.setSubject("测试 !","UTF-8");
			
			message.setText("Hi Watie!Test!This is actual message","text/html;charset=UTF-8");
			message.setSentDate(new Date());
			
			//transport.sendMessage(message,message.getAllRecipients());
			transport.sendMessage(message, new Address[]{new InternetAddress(to)});
			transport.close();
	        System.out.println("Sent message successfully....");
		}catch (MessagingException mex) {
	         mex.printStackTrace();
	    }
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
