package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RedirectController {
	
	@RequestMapping("/one")
	public String one() {
		System.out.println("one handler");
		return "redirect:/two";
	}
	
	@RequestMapping("/two")
	public RedirectView two() {
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("home");
		System.out.println("second handler");
		return redirectView;
	}
}	
