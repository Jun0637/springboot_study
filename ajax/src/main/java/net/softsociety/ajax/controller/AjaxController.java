package net.softsociety.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.ajax.domain.Aj;

@Slf4j
@RequestMapping("aj")
@Controller
public class AjaxController {
	@GetMapping("aj1")
	public String aj1() {
			
		return "aj/aj1";
	}
	
	@ResponseBody
	@GetMapping("test1")
	public void test1() {
		log.debug("Controller test실행");
	}
	
	@ResponseBody
	@GetMapping("test2")
	public String test2(String str, String num) {
		log.debug(str);
		log.debug(num);
		return "서버에서 보내는값";
	}
	
	@ResponseBody
	@GetMapping("test3")
	public String test3(String text) {
		log.debug("전달된 값:{}", text);
		String s = text.toUpperCase();
		return s;
	}
	
	@GetMapping("aj2")
	public String aj2() {
			
		return "aj/aj2";
	}
	
	@ResponseBody
	@PostMapping("insert1")
	public void insert1(String name1, int age1, String phone1) {
		log.debug("저장되었습니다. 이름:{}", name1);
		log.debug("저장되었습니다. 나이:{}", age1);
		log.debug("저장되었습니다. 번호:{}", phone1);
		return;
	}
	
	@ResponseBody
	@PostMapping("insert2")
	public void insert2(Aj aj) {
		log.debug("저장되었습니다:{}", aj);
		return;
	}
}
