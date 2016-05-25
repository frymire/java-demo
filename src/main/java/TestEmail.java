
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
//import javax.activation.*;
 
// Send a simple, single part, text/plain e-mail
public class TestEmail {
 
    public static void main(String[] args) {
 
        String to = "mark.frymire@dac.us";
        String from = "mark.frymire@icloud.com";
        String host = "smtp.mail.me.com";
 
        // Create properties, get Session
        Properties props = new Properties();
 
        // If using static Transport.send(),
        // need to specify which host to send it to
        props.put("mail.smtp.host", host);
        // To see what is going on behind the scene
        props.put("mail.debug", "true");                
        props.put("mail.smtp.starttls.enable", "true");
     
        Session session = Session.getInstance(props);
 
        try {
        	
            // Instantiate a message
            Message msg = new MimeMessage(session);
 
            //Set message attributes
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject("Test E-Mail through Java");
            msg.setSentDate(new Date());
 
            // Set message content
            msg.setText("This is a test of sending a " +
                        "plain text e-mail through Java.\n" +
                        "Here is line 2.");
 
            //Send the message
            // TODO: put the password in here (need to set up an Authenticator to encrypt it)
            Transport.send(msg, "mark.frymire@icloud.com", null);
        }
        catch (MessagingException mex) {
            // Prints all nested (chained) exceptions as well
            mex.printStackTrace();
        }
    }
    
}//End of class