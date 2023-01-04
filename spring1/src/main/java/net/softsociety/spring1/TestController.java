package net.softsociety.spring1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("/test1") //경로명
	public String test1() {
		return "/view1";
	}
	@GetMapping("/aaa/bbb") //URL 프로젝트의 가장 상의 기준 절대경로
	public String view2() {
		return "/view2";
	}
	@GetMapping("/test2")
	public String view3() {
		return "/view3";
	}
	@GetMapping("/test3")
	public String view4() {
		return "/view4";
	}
}
