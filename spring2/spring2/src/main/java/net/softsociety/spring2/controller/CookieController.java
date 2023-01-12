package net.softsociety.spring2.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/cookie")
@Controller
public class CookieController {
	@GetMapping("/ck1")
	public String ck1(HttpServletResponse res) {
		//쿠키 생성
		Cookie c1 = new Cookie("str", "abcde");
		Cookie c2 = new Cookie("num", "123");
		//쿠키 유지 시간 설정
		c1.setMaxAge(60*60*24*3);
		c2.setMaxAge(60*60*24*3);
		//응답 정보에 쿠키 추카
		res.addCookie(c1);
		res.addCookie(c2);
		return "redirect:/";
	}
	@GetMapping("/ck2")
	public String ck2(
			@CookieValue(name="str", defaultValue="없음") String str
			, @CookieValue(name="num", defaultValue="0") int num) {
		
		log.debug("str 쿠키 값 : {}", str);
		log.debug("str 쿠키 값 : {}", num);
		
		return "redirect:/";
	}
	@GetMapping("/ck3")
	public String ck3(HttpServletResponse res) {
		//쿠키 삭제
		Cookie c1 = new Cookie("str", null);
		Cookie c2 = new Cookie("num", null);
		//쿠키 유지 시간 설정
		c1.setMaxAge(0);
		c2.setMaxAge(0);
		//응답 정보에 쿠키 추카 동시에 저장
		res.addCookie(c1);
		res.addCookie(c2);
	
		return "redirect:/";
	}
}
