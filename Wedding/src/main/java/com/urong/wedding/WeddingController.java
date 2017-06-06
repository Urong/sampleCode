package com.urong.wedding;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WeddingController {

	@RequestMapping(value = "/home")
	public ModelAndView showMainView(ModelAndView mav) {

		mav.setViewName("html/wedding");

		return mav;
	}

}
