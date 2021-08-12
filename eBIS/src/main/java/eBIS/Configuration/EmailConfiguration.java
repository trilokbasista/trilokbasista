package eBIS.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;

@Controller
public class EmailConfiguration {
	@Autowired
    private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.ccmail}")
    private String MailCCEmail;
	
	@Value("${spring.mail.from.email}")
    private String MailFromEmail;

	public void SingleMailSender(String MailTo,String MailCCEmail[],String Subject, String Message) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(MailFromEmail);
        msg.setBcc(MailTo);
        msg.setCc(MailCCEmail);
        msg.setSubject(Subject);
        msg.setText(Message);
       javaMailSender.send(msg);
    }

	public void BulkMailSender(String MailTo[],String MailCCEmail[],String Subject, String Message) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(MailFromEmail);
        msg.setBcc(MailTo);
        msg.setCc(MailCCEmail);
        msg.setSubject(Subject);
        msg.setText(Message);
        javaMailSender.send(msg);
    }
}
