package com.adver.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {

	@RequestMapping("/")
	public ModelAndView mian(){
		ModelAndView md = new ModelAndView("index.html");
		return md;
	}
	
}