package net.softsociety.spring1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("/test1") //경로명
	public String test1() {
		return "/view1";
	}
	@GetMapping("/aaa/bbb") //경로명
	public String test2() {
		return "/view2";
	}
	@GetMapping("/test3") //경로명
	public String test3() {
		return "/view3";
	}
}
