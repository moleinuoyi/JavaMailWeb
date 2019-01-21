package zwt.test;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class POP3Test {
	public static void main(String[] args) {
		String host = "zwt.com";
		String username = "zjj@zwt.com";
		String password = "123321";
		//ÅäÖÃ·þÎñÆ÷
		Properties props = new Properties();
		props.put("mail.smtp.host", "localhost");//
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "25");
		props.put("mail.transport.protocol", "smtp"); 
		props.put("mail.store.protocol", "pop3");
		
		Session session = Session.getDefaultInstance(props, null); 
		//session.setDebug(true);
		try {
			Store store = session.getStore("pop3");
			store.connect("zwt.com", username, password);
			Folder folder = store.getFolder("inbox");  
			folder.open(Folder.READ_ONLY); 
			Message message[] = folder.getMessages();
			for (int i = 0; i < message.length; i++) {
				System.out.println(i + ":" + message[i].getFrom()[0] + "\t"     
                        + message[i].getSubject());
			}
			folder.close(false); 
			store.close();
			
		}catch (NoSuchProviderException e) {  
			e.printStackTrace(); 
		}catch (MessagingException e) {
			e.printStackTrace(); 
		}
	
	}
}
