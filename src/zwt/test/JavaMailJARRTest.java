package zwt.test;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailJARRTest {

	public static void main(String[] args) throws AddressException, MessagingException {
		// TODO Auto-generated method stub
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "SMTP");
		props.setProperty("mail.smtp.host", "smtp.163.com");
		props.setProperty("mail.smtp.port", "25");
		// 指定验证为true
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.timeout","1000");
		
		Authenticator auth = new Authenticator() {
			 public PasswordAuthentication getPasswordAuthentication(){
				 return new PasswordAuthentication("17512081186@163.com", "zwt123");
			 }
		};
		Session session = Session.getInstance(props, auth);
		Message message = new MimeMessage(session);
		// 设置发送者
		message.setFrom(new InternetAddress("17512081186@163.com"));
		
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("2598283973@qq.com"));
		message.setSubject("邮件发送测试");
		message.setContent("Hi Waite!!", "text/html;charset=utf-8");
		Transport.send(message);
		System.out.println("SUCCESS!");
	}
}
