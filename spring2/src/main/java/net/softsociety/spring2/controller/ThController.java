package net.softsociety.spring2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring2.domain.Person;


@Slf4j
@RequestMapping("/th")
@Controller
public class ThController {
	
	@GetMapping("/thtest1")
	public String thtest1(Model model) {
		String str = "abcd";
		int num = 100;
		Person p = new Person("aaa", "홍길동", "111","010-1111-1111","KT");
		String tag = "<marquee>HTML태그가 포함된 문자열</marquee>";
		String url = "https://google.com";
		
		model.addAttribute("str", str);
		model.addAttribute("num", num);
		model.addAttribute("person", p);
		model.addAttribute("tag", tag);
		model.addAttribute("url", url);
		
		return "thview/thview1";
	}
	
	@GetMapping("/thtest2")
	public String thtest2(Model model) {
		
		return "thview/thview2";
	}
}
