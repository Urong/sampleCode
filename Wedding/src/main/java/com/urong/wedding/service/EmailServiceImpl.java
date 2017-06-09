package com.urong.wedding.service;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.WebContext;

import com.urong.wedding.model.User;

@Service
public class EmailServiceImpl extends Authenticator implements EmailService {

	final static Logger logger = Logger.getLogger(EmailServiceImpl.class);

	@Autowired
	private TemplateEngine templateEngine;

	private final static String id = "june.heeny.wedding@gmail.com";
	private final static String pw = "dudwns1234";

	private PasswordAuthentication pa;

	public EmailServiceImpl() {
		pa = new PasswordAuthentication(id, pw);
	}

	public PasswordAuthentication getPasswordAuthentication() {
		return pa;
	}

	@Async
	@Override
	public void sendMail(User user, String subject, String text) {
		Properties p = System.getProperties();
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.port", "587");

		Authenticator auth = new EmailServiceImpl();
		Session session = Session.getDefaultInstance(p, auth);
		MimeMessage msg = new MimeMessage(session);

		try {
			msg.setSentDate(new Date());
			InternetAddress from = new InternetAddress();
			from = new InternetAddress("June & Heeny <" + id + ">");

			msg.setFrom(from);
			InternetAddress to = new InternetAddress(user.getEmail());
			msg.setRecipient(Message.RecipientType.TO, to);

			msg.setSubject(subject, "UTF-8");
			msg.setText(text, "UTF-8");

			msg.setHeader("content-Type", "text/html");

			javax.mail.Transport.send(msg);
			logger.info("send email...");

		} catch (AddressException addr_e) {
			logger.error(addr_e.getMessage());
			addr_e.printStackTrace();
		} catch (MessagingException msg_e) {
			logger.error(msg_e.getMessage());
		}
	}

	@Async
	@Override
	public void sendMailByRecipients(List<User> users, String subject, String htmlContent) throws MessagingException {
		Properties p = System.getProperties();
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.port", "587");

		Authenticator auth = new EmailServiceImpl();
		Session session = Session.getDefaultInstance(p, auth);

		MimeMessage msg = new MimeMessage(session);
		MimeMessageHelper msgHelper = new MimeMessageHelper(msg, true, "UTF-8");

		StringBuffer sb = new StringBuffer();

		try {
			msg.setSentDate(new Date());
			InternetAddress from = new InternetAddress("June & Heeny <" + id + ">");

			for (User user : users) {
				sb.append(user.getEmail());
				sb.append(",");
			}

			msgHelper.setFrom(from);
			msgHelper.setTo(InternetAddress.parse(sb.toString()));
			msgHelper.setSubject(subject);
			msgHelper.setText(htmlContent, true);

			javax.mail.Transport.send(msg);
			logger.info("send email...");

		} catch (AddressException addr_e) {
			logger.error(addr_e.getMessage());
			addr_e.printStackTrace();
		} catch (MessagingException msg_e) {
			logger.error(msg_e.getMessage());
		}

	}

	@Override
	public String makeTemplate(WebContext ctx, Context cx, String templateName) {
		return ctx != null ? templateEngine.process(templateName, ctx) : templateEngine.process(templateName, cx);
	}

}
