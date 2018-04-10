package com.younggambyeon.isp;

public class Client {
	
	public static void main(String[] args) {
		// 인터페이스는 그 인터페이스를 사용하는 클라이언트를 기준으로 분리해야 한다.

		EmailService emailService = new EmailServiceImpl();
		FileService fileService = new FileServiceImpl();

		emailService.sendEmail("younggambyeon@gmail.com");
		fileService.readFile("C:\\Users\\modacom\\Desktop\\solid.doc");
	}
}
