package net.softsociety.spring2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class ParamController {
	//입력화면으로 이동
	@GetMapping("/param/test1")
	public String test1() {
		return "/paramView/view1";
	}
	
	//입력한 내용 전달받아 처리
	@GetMapping("/param/input1")
	public String input1(String name, int age) { //spring에서 자동변환해줌
		System.out.println(name);
		System.out.println(age);
		return "redirect:/"; //메인으로 돌아가라
	}
}
