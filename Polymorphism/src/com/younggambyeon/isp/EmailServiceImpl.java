package com.younggambyeon.isp;

public class EmailServiceImpl implements EmailService {

	@Override
	public void sendEmail(String email) {
		System.out.println(email + " 에게 메일을 발송하였습니다.");

	}

}
