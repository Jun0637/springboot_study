package net.softsociety.spring3.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	//전달된 주민등록번호의 회원 삭제
	@GetMapping("/delete")
	public String delete(String idnum) {
		log.debug("삭제할 주민등록번호:{}", idnum);
		//서비스 클래스로 주민등록번호 전달하여 삭제
		service.deletePerson(idnum);
		//메인 화면으로 리다이렉트
		return "redirect:/select";
		
	}
	
	@GetMapping("/delete2")
	public String delete2(String name) {
		log.debug("이름 삭제:{}", name);
		//서비스 클래스로 이름 전달하여 삭제
		service.delete2Person(name);
		//메인 화면으로 리다이렉트
		return "redirect:/";
		
	}
	
	@GetMapping("/selectOne")
	public String select(String idnum, Model model) {
		log.debug("조회할 주민등록번호:{}", idnum);
		//서비스 클래스로 주민등록번호 전달
		Person person = service.selectOne(idnum);
		model.addAttribute("person",person);
		return "/viewPerson";
		
	}
	
	@GetMapping("/select")
	public String select(Model model) {
		ArrayList<Person>list = service.select();
		model.addAttribute("list", list);
		return "/viewList";
	}
	
	@GetMapping("/update")
	public String update(String idnum, Model model) {
		Person person = service.selectOne(idnum);
		model.addAttribute("person", person);
		return "/updateForm";
	}
}
