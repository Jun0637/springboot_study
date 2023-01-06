package net.softsociety.spring2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/session")
@Controller
public class SessionController {

	@GetMapping("/stest1")
	public String stest1(HttpSession session) {
		session.setAttribute("id", "abc");
		return"/sessionView/ss1";
	}
	
	@GetMapping("/stest2")
	public String stest2(HttpSession session) {
		String id =(String) session.getAttribute("id");
		log.debug("세션의 값 : {}" , id);
		return"redirect:/";
	}
	
	@GetMapping("/stest3")
	public String stest3(HttpSession session) {
		session.removeAttribute("id");
		return"redirect";
	}
}
