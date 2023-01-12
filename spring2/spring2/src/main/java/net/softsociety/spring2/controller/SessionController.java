package net.softsociety.spring2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/stest4")
	public String stest4() {
		return"/sessionView/loginForm";
	}
	
	@PostMapping("/stest5")
	public String stest5(
			String id
			, String pw
			, HttpSession session
			, HttpServletRequest req) {
		
		log.debug("요청정보 : {}", req.getRemoteAddr());
		
		//ID와 비밀번호가 맞는지 확인
		if(id.equals("abc") && pw.equals("123")) {
			//맞으면 세션에"loginID"이름으로 ID를 저장
			 session.setAttribute("loginID", id);
			//메인화면으로 리다이렉트
		return"redirect:/";
		}
		else {
			//틀리면 로그인폼 HTML로 포워딩
			return"/sessionView/loginForm";
		}
	}
	@GetMapping("/ck1")
	public String ck1() {
		return"redirect:/";
	}
}
