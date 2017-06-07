package com.urong.wedding.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.context.Context;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.urong.wedding.component.DataManager;
import com.urong.wedding.model.Rsvp;
import com.urong.wedding.model.User;
import com.urong.wedding.service.EmailService;
import com.urong.wedding.util.CommonUtil;

@Controller
public class DefaultController {

	@Autowired
	private DataManager dataManager;

	@Autowired
	private EmailService emailService;

	@RequestMapping(value = "/")
	public ModelAndView showMainView(ModelAndView mav) {

		mav.setViewName("html/wedding");

		return mav;
	}

	@RequestMapping(value = "/rsvp", method = RequestMethod.POST)
	public @ResponseBody String confirmRsvp(@RequestBody Rsvp rsvp) {

		rsvp.setIdx(dataManager.getUserQueue().size() + 1);
		rsvp.setDate(CommonUtil.getCurrenDate());

		dataManager.getUserQueue().add(rsvp);

		return "success";
	}

	@RequestMapping(value = "/list")
	public @ResponseBody String makeList() throws MessagingException, JsonProcessingException {
		Rsvp rsvp = new Rsvp();

		rsvp.setIdx(dataManager.getUserQueue().size() + 1);
		rsvp.setName("변영준1");
		rsvp.setFlag("참석");
		rsvp.setDate(CommonUtil.getCurrenDate());

		dataManager.getUserQueue().add(rsvp);

		Rsvp rsvp1 = new Rsvp();

		rsvp1.setIdx(dataManager.getUserQueue().size() + 1);
		rsvp1.setName("변영준2");
		rsvp1.setFlag("참석");
		rsvp1.setDate(CommonUtil.getCurrenDate());

		dataManager.getUserQueue().add(rsvp1);

		Rsvp rsvp2 = new Rsvp();

		rsvp2.setIdx(dataManager.getUserQueue().size() + 1);
		rsvp2.setName("변영준3");
		rsvp2.setFlag("참석 불가");
		rsvp2.setDate(CommonUtil.getCurrenDate());

		dataManager.getUserQueue().add(rsvp2);

		ObjectMapper mapper = new ObjectMapper();

		return mapper.writeValueAsString(dataManager.getUserQueue());
	}

	@RequestMapping(value = "/test")
	public @ResponseBody String testEmail() throws MessagingException {

		Rsvp endRsvp = new Rsvp(0, "", "금일 종료", CommonUtil.getCurrenDate());

		dataManager.getUserQueue().add(endRsvp);

		List<User> users = new ArrayList<User>();
		User youngjun = new User("dudwns519@daum.net", "변영준");

		users.add(youngjun);

		String subject = "금일 참석여부 확인 메일입니다";

		Context cx = new Context(Locale.KOREA);
		cx.setVariable("rsvps", dataManager.getUserQueue());

		String htmlContent = emailService.makeTemplate(null, cx, "InvitationTemplate");

		emailService.sendMailByRecipients(users, subject, htmlContent);

		return "success";
	}

}
