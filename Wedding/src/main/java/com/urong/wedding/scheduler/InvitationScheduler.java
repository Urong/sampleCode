package com.urong.wedding.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;

import com.urong.wedding.component.DataManager;
import com.urong.wedding.model.Rsvp;
import com.urong.wedding.model.User;
import com.urong.wedding.service.EmailService;
import com.urong.wedding.util.CommonUtil;

@EnableScheduling
@Component
public class InvitationScheduler {

	private static final Logger logger = LoggerFactory.getLogger(InvitationScheduler.class);

	@Autowired
	private DataManager dataManager;

	@Autowired
	private EmailService emailService;

	@Scheduled(cron = "00 00 00 * * *")
	public void confirmInvitation() throws MessagingException {

		logger.info("금일 참석여부 확인 메일 발송합니다.");

		Rsvp endRsvp = new Rsvp(0, null, null, CommonUtil.getCurrenDate());

		dataManager.getUserQueue().add(endRsvp);

		List<User> users = new ArrayList<User>();
		User youngjun = new User("dudwns519@daum.net", "변영준");
		User Heeeun = new User("lovelove006@naver.com", "임희은");

		users.add(youngjun);
		users.add(Heeeun);

		String subject = "예식 참석여부 목록입니다";

		Context cx = new Context(Locale.KOREA);
		cx.setVariable("rsvps", dataManager.getUserQueue());

		String htmlContent = emailService.makeTemplate(null, cx, "InvitationTemplate");

		emailService.sendMailByRecipients(users, subject, htmlContent);
	}
}
