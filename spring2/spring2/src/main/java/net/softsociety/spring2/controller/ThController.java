package net.softsociety.spring2.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

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
		
		int a =10000;
		double b = 123.45678;
		double c = 8.5;
		Date d = new Date();
		
		model.addAttribute("inum",a);
		model.addAttribute("dnum",b);
		model.addAttribute("dnum2",c);
		model.addAttribute("date",d);
		
		return "thView/thview1";
	}
	
	@GetMapping("/thtest2")
	public String thtest2(Model model) {
		String str ="abc";
		int num = 1;
		String values = "Java,CSS,HTML";
		
		ArrayList<String>list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("name","키보드");
		map.put("price", 100);
		
		model.addAttribute("str", str);
		model.addAttribute("num", num);
		model.addAttribute("values", values);
		model.addAttribute("list", list);
		model.addAttribute("map", map);
		
		return "thView/thview2";
	}
}
