package mreze;

import java.util.Date;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	
	public static void sendEmail(Session session, String toEmail, String subject, String body) {
		
		try {
			MimeMessage msg = new MimeMessage(session);
			
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
		    msg.addHeader("format", "flowed");
		    msg.addHeader("Content-Transfer-Encoding", "8bit");
		    
		    msg.setFrom(new InternetAddress(Login.getInstance().getTfEmail().getText(), "SMTP klijent"));

		    msg.setReplyTo(InternetAddress.parse(Login.getInstance().getTfEmail().getText(), false));

		    msg.setSubject(subject, "UTF-8");

		    msg.setText(body, "UTF-8");

		    msg.setSentDate(new Date());

		    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
		    System.out.println("Message is ready");
		    Transport.send(msg);  

		    System.out.println("Email sent successfully");
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
