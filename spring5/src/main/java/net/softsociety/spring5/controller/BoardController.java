package net.softsociety.spring5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("board")
@Controller
public class BoardController {

	// "/board/list" 경로의 요청을 처리하는 메소드 
	@GetMapping("list")
	public String list() {
		return "boardView/list";
	}


}
