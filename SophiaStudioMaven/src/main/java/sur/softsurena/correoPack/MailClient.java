package sur.softsurena.correoPack;

import java.util.Properties;
import java.util.logging.Level;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class MailClient {

    public void sendMail(String from, String to, String subject,
            String messageBody) throws MessagingException, AddressException {
        // Setup mail server 
        String host = "smtp.gmail.com"; 
        String username = "Jhironseld@gmail.com"; 
        String password = "hqqqccgwcajgnile";
        
        Properties props = new Properties(); 
        props.put("mail.smtps.auth", "true");

        //Get a mail session 
        Session session = Session.getDefaultInstance(props, null);
        
        //Define a new mail message 
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setText(messageBody);

        // Send the message 
        Transport t = session.getTransport("smtps"); 
        try { 
            t.connect(host, username, password); 
            t.sendMessage(message, message.getAllRecipients()); 
        } finally { 
            t.close(); 
        }
    }

    public static void main(String[] args) {
        try {
            MailClient client = new MailClient();
            String from = "Jhironseld@gmail.com";
            String to = "8292972015@smtp.claro.net.do";
            String subject = "Test";
            String message = "I'm testing. Do you see this?";

            client.sendMail(from, to, subject, message);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }
}
