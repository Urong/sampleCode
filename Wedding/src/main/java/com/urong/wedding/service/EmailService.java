package com.urong.wedding.service;

import java.util.List;

import javax.mail.MessagingException;

import org.thymeleaf.context.Context;
import org.thymeleaf.context.WebContext;

import com.urong.wedding.model.User;


public interface EmailService {

	public void sendMail(User user, String subject, String text);

	public void sendMailByRecipients(List<User> users, String subject, String htmlContent) throws MessagingException;

	public String makeTemplate(WebContext ctx, Context cx, String templateName);

}
