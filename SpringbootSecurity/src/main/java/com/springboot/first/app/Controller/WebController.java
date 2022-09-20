package com.springboot.first.app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
	@GetMapping("/hello")
	public String hello() {
		return "/hello";
	}
	
	@GetMapping(value = {"/","/home"})
	public String home(){
		return "/home";
	}
}
