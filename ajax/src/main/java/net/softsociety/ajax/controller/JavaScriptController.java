package net.softsociety.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("javascript")
public class JavaScriptController {

	@GetMapping("js1")
	public String js1() {
		return "js/js1";
	}
	
	@GetMapping("js2")
	public String js2() {
		return "js/js2";
	}
	
	@GetMapping("js3")
	public String js3() {
		return "js/js3";
	}
	
	@GetMapping("js4")
	public String js4() {
		return "js/js4";
	}
	
}
