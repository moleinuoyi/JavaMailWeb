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
		//�ռ��˵�ַ
		String to = "2598283973@qq.com";
		//�����˵�ַ
		String from = "test@zwt.com";
		//�������˻�
		String senderAccount = "test@zwt.com";
		//����������
		String senderPassword = "123321";
		//��������
		String host = "192.168.56.1";
		
		Properties properties = System.getProperties();
		
		properties.setProperty("mail.smtp.auth", "true");//�����û�����֤��ʽ
		properties.setProperty("mail.transport.protocol", "smtp");//���ô���Э��
		properties.setProperty("mail.smtp.port", "25"); 		// ����smtp�˿� 
//		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.host", host);			//���÷����˵�SMTP��������ַ
		properties.put("mail.smtp.ssl.enable", "true"); 		// �����Ƿ�ʹ��ssl��ȫ���� ---һ�㶼ʹ��
		try {
			
			Session session = Session.getDefaultInstance(properties);
			session.setDebug(true);
			Transport transport = session.getTransport();//ͨ��session�õ�transport����
			//3��ʹ��������û��������������ʼ��������������ʼ�ʱ����������Ҫ�ύ������û����������smtp���������û��������붼ͨ����֤֮����ܹ����������ʼ����ռ��ˡ�
			transport.connect(senderAccount, senderPassword);
			
			MimeMessage message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(from));
			
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			message.setSubject("���� !","UTF-8");
			
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
