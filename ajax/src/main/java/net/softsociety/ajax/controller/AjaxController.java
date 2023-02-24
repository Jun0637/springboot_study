package net.softsociety.ajax.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.ajax.domain.Person;

@Slf4j
@Controller
@RequestMapping("aj")
public class AjaxController {

	@GetMapping("aj1")
	public String aj1() {
		return "aj/aj1";
	}
	
	@ResponseBody
	@GetMapping("test1")
	public void test1() {
		log.debug("Controller의 test1 실행");
	}
	
	@ResponseBody
	@GetMapping("test2")
	public String test2(String str) {
		log.debug(str);
		return "서버에서 보내는 값";
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
	public void insert1(String name, int age, String phone) {
		log.debug("name:{}, age:{}, phone:{}", name, age, phone);
	}
	
	@ResponseBody
	@GetMapping("getObject")
	public Person getObject() {
		Person p = new Person("홍길동", 22, "010-1111-1111");
		return p;
	}
	
	@ResponseBody
	@GetMapping("getList")
	public ArrayList<Person> getList() {
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("홍길동", 22, "010-1111-1111"));
		list.add(new Person("김길동", 33, "010-2222-2222"));
		list.add(new Person("박길동", 44, "010-3333-3333"));
		return list;
	}
	
	@ResponseBody
	@PostMapping("sendList")
	public void sendList(String[] ar) {
		for (String s : ar) {
			log.debug(s);
		}
	}

	@ResponseBody
	@PostMapping("sendObjectList")
	public void sendObjectList(String ar) throws Exception {
		log.debug("전달받은 문자열 : {}", ar);
		
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<Person> list 
		= mapper.readValue(ar, new TypeReference<ArrayList<Person>>() {});
		
		log.debug("변환된 객체 : {}", list);
	}


}




