package net.softsociety.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("jquery")
public class JQueryController {
	@GetMapping("jq1")
	public String jq1() {
		return "jq/jq1";
	}

}
