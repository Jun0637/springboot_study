package net.softsociety.spring5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring5.domain.Member;
import net.softsociety.spring5.service.MemberService;
/**
 * 회원 관련 처리 컨트롤러
 */

@Slf4j
@RequestMapping("/member")
@Controller
public class MemberController {
	
	@Autowired
	MemberService service;
	
	/**
	 * 	회원 가입 폼으로 이동
	 * @return 회원가입 양식 HMTL
	 */
	@GetMapping("/join")
	public String join() {
		
		return "/memberView/joinForm";
	}
	
	@PostMapping("/join")
	public String join(Member member) {
		log.debug("가입데이터 : {}", member);
		service.insert(member);
		return "redirect:/";
	}
}
