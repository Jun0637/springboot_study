package net.softsociety.spring2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/ex")
@Controller
public class ExController {
	@GetMapping("/test1")
	public String test1() {
		/**
		 * 계산기 폼에서 입려한 값을 전달받아 계산하고 결과페이지로 포워딩
		 * @param model
		 * @param op 연산자
		 * @param num1 피연산자1
		 * @param num2 피연산자2
		 * @param return 결과 출력할 HTML 파일*/
		
		return "exView/view1";
	}
	
	@PostMapping("/test1")
	public String test1(Model model, String op, int num1, int num2) {
		//계산처리
		int res = 0;
		switch(op) {
		case"+": res = num1 + num2;break;
		case"-": res = num1 - num2;break;
		case"*": res = num1 * num2;break;
		case"/": res = num1 / num2;break;
		}
		model.addAttribute("op", op);
		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		model.addAttribute("res", res);
		return "/exView/result1";
	}

}
