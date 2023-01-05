package net.softsociety.spring2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.softsociety.spring2.domain.Person;

@Controller
public class ParamController {
	// 입력화면으로 이동
	@GetMapping("/param/test1")
	public String test1() {
		return "/paramView/view1";
	}

	// 입력한 내용 전달받아 처리
	@GetMapping("/param/input1")
	public String input1(String name, int age) { // spring에서 자동변환해줌
		System.out.println(name);
		System.out.println(age);
		return "/paramView/view1";
		// return "redirect:/"; //메인으로 돌아가라
	}

	// 입력한 화면으로 이동
	@GetMapping("/param/test2")
	public String test2() {
		return "/paramView/view2";
	}

	//
	@PostMapping("/param/input2")
	public String input2(String id, String password, String name, String phone, String com) {
		System.out.println(id);
		System.out.println(password);
		System.out.println(name);
		System.out.println(phone);
		System.out.println(com);
		return "redirect:/";
	}

	@GetMapping("/param/test3")
	public String test3() {
		return "/paramView/view3";
	}

	@PostMapping("/param/input3")
	public String input3(Person p) {
		System.out.println(p);
		return "redirect:/";
	}
}
