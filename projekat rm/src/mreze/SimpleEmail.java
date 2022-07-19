package mreze;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class SimpleEmail {
	
	
	public static void send() {
		
		
		final String fromEmail = Login.getInstance().getTfEmail().getText(); 
		final String password = Login.getInstance().getTfPassword().getText();  
		final String toEmail = MainFrame.getInstance().getToEmail().getText();  
		final String subject = MainFrame.getInstance().getSubject().getText(); 
		final String body = MainFrame.getInstance().getBody().getText();
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); 
		props.put("mail.smtp.port", "587"); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.starttls.enable", "true"); 
		
                
		Authenticator auth = new Authenticator() {
			
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);
		
		Email.sendEmail(session, toEmail,subject, body);
		
	}

		
	
}
