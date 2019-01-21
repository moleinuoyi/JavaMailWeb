package zwt.test;



import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.URLName;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.util.MailSSLSocketFactory;

public class Test2 {
	public static void main(String[] args) throws GeneralSecurityException {
		String sender = "test@zwt.com";
		String password = "123321";
		String smtpServer = "zwt.com";
		//String recipient = "2598283973@qq.com";
		String recipient = "zjj@zwt.com";
		String subject = "测试邮件主题";
		String fileAttachment = "";//附件
		String content = "Hi!Waite,z-elsa L ZJJ";
		
		Properties proper = new Properties();
		
		proper.put("mail.smtp.host", smtpServer);		// smtp服务器       
        proper.put("mail.smtp.auth", "true"); 			// 是否smtp认证       
        proper.put("mail.smtp.port", "25"); 			// 设置smtp端口       
        proper.put("mail.transport.protocol", "smtp"); 	// 发邮件协议       
        proper.put("mail.store.protocol", "pop3"); 		// 收邮件协议
       //SSL
//        proper.put("mail.smtp.ssl.enable", "true"); // 设置是否使用ssl安全连接 ---一般都使用
//        proper.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
//        proper.setProperty("mail.smtp.socketFactory.fallback", "false");
         
//        MailSSLSocketFactory sf = new MailSSLSocketFactory();  
//        sf.setTrustAllHosts(true);  
//        proper.put("mail.smtp.ssl.enable", "true");  
//        proper.put("mail.smtp.ssl.socketFactory", sf);
//        
//        proper.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        proper.put("mail.smtp.localhost", "localhost"); 
//        proper.put("mail.smtp.auth", "false");
        
        InternetAddress[] receiveAddress = new InternetAddress[1];    
        try {       
            receiveAddress[0] = new InternetAddress(recipient);       
        } catch (AddressException e) {       
            e.printStackTrace();       
        }  
        // smtp认证，获取Session 
        SmtpAuth sa = new SmtpAuth(); 
        sa.setUserinfo(sender, password); 
        
        Session session = Session.getInstance(proper, sa);
        session.setDebug(true);
        session.setPasswordAuthentication(new URLName(smtpServer), sa.getPasswordAuthentication()); 
        // 构建邮件体
        MimeMessage sendMess = new MimeMessage(session); 
        MimeBodyPart mbp = new MimeBodyPart();
        MimeMultipart mmp = new MimeMultipart(); 
        try { 
        	mbp.setContent(content, "text/html;charset=UTF-8");
        	mmp.addBodyPart(mbp);
        	// 附件处理 
        	if(fileAttachment!=null && fileAttachment!=""){
        		DataSource source = new FileDataSource(fileAttachment);
        		String name = source.getName();
        		mbp = new MimeBodyPart(); 
        		mbp.setDataHandler(new DataHandler(source));
        		mbp.setFileName(name);       
                mmp.addBodyPart(mbp);
        	}
        	// 邮件整体
        	sendMess.setSubject(subject);
        	sendMess.setContent(mmp);
        	// 发送邮件
        	sendMess.setFrom(new InternetAddress(sender));
        	sendMess.setRecipients(Message.RecipientType.TO,receiveAddress);
        	Transport.send(sendMess); 
        	System.out.println("success!"); 
        }catch (MessagingException ex) {
        	ex.printStackTrace();
        }
        
	}
}
class SmtpAuth extends javax.mail.Authenticator {
	private String user;
	private String password;
	public void setUserinfo(String getuser, String getpassword) {       
        user = getuser;       
        password = getpassword;       
    }
	protected javax.mail.PasswordAuthentication getPasswordAuthentication() {       
        return new javax.mail.PasswordAuthentication(user, password);       
    }
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
