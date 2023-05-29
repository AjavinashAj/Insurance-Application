package com.avinashit.util;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {
    @Autowired
	private JavaMailSender mailSender;
    
   

	public Boolean sendEmail(String subject, String body, String to,File f)  {
		
try {
    		
    		MimeMessage mimeMsg= mailSender.createMimeMessage();
    		MimeMessageHelper helper=new MimeMessageHelper(mimeMsg,true);
    		helper.setSubject(subject);
    		helper.setText(body,true);
    		helper.setTo(to);
    		helper.addAttachment("plans-info", f);
    		mailSender.send(mimeMsg);
    		
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		return true;
	}
}
