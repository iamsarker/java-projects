import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


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
			
			
			BodyPart messageBodyPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();
			
			// normal body text message part
			messageBodyPart.setText("helooo buddy!!!! [ message body ]");
			multipart.addBodyPart(messageBodyPart);
			
			// file attachment part
			messageBodyPart = new MimeBodyPart();
			String filename = "file.txt"; // file name with path
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);
			
			//message.setContent("<h1>HTML message","text/html"); // for html message
			
			message.setContent(multipart );
			
			Transport.send(message);
			
			System.out.println("Sent message successfully....");
			
		} catch(MessagingException me){
			me.printStackTrace();
		}
	}
}
