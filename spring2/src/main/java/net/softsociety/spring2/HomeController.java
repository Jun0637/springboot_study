package net.softsociety.spring2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@GetMapping({"", "/"})
	public String home() {
		return "/home";
	}
	
	@GetMapping("/logtest")
	public String logtest(){
		String s = "어떤 문자열";
		System.out.println("logtest 실행됨" + s);
		
		return "/home";
	}
}
