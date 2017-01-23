package com.urong.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/security-context.xml" })
@WebAppConfiguration
public class ClientTest {

	public ClientTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void setClient() {
		String url = "http://10.0.0.205:8080/sample/call";
		RestTemplate rest = new RestTemplate();
		String returnResult = rest.getForObject(url, String.class);

		System.out.println(returnResult);

	}
}
