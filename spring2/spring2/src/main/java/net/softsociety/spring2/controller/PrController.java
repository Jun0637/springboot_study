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
public class PrController {
	@GetMapping("test2")
	public String test2() {

		return "exView/view2";
	}

	@PostMapping
	public String test2(Model model, String name, String num, int age) {

		model.addAttribute("name", name);
		model.addAttribute("num", num);

		return "exView/result2";
	}
}
