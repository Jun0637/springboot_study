package net.softsociety.spring3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring3.domain.Person;
import net.softsociety.spring3.service.PersonService;

/**
 * 회원 정보의 입력/수정/삭제/조회 처리
 */
@Slf4j
@Controller
public class PersonController {
	@Autowired
	PersonService service;
	
	//입력 폼으로 이동
	@GetMapping("/insert")
	public String insert() {
		return "/insertForm";
	}
	
	//입력폼에서 전달된 값 저장
	@PostMapping("/insert")
	public String insert(Person person) {
		log.debug("전달된 값:{}", person);

		service.insertPerson(person);
		
		return "redirect:/";
	}
	
}
