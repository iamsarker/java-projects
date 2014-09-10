import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


public class SendEmail {
	public static void main(String[] args){
		
		String to = "xxxx@gmail.com"; //Recipient's email ID
		
		String from = "yyyy@gmail.com"; // Sender's email ID
		
		String host = "localhost"; //sending email from localhost [ You have to config smtp server/relay to your localhost].
		
		Properties properties = System.getProperties(); // get system properties
		
		properties.setProperty("mail.smtp.host", host); // setup mail server
		
		Session session = Session.getDefaultInstance(properties); // get default session object
		
		try{
			MimeMessage message = new MimeMessage(session); // create mime message object
			
			message.setFrom(new InternetAddress(from)); // add sender mail id
			
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); // add mail receiver email id
			message.setSubject("Helooooo!!!");
			
			message.setText("helooo buddy!!!!");
			
			//message.setContent("<h1>HTML message","text/html"); // for html message
			
			Transport.send(message);
			
			System.out.println("Sent message successfully....");
			
		} catch(MessagingException me){
			me.printStackTrace();
		}
	}
}
