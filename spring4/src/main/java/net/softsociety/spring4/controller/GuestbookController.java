package net.softsociety.spring4.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring4.domain.Guestbook;
import net.softsociety.spring4.service.GuestbookService;

/**
 * 방명록 처리
 */
@Slf4j
@Controller
public class GuestbookController {
	@Autowired
	GuestbookService service;
	
	//방명록 화면으로 이동
	@GetMapping("/list")
	public String list(Model model) {
		ArrayList<Guestbook> glist = service.list();
		model.addAttribute("glist", glist);
		return "/list";
	}
	
	//글쓰기 폼으로 이동
	@GetMapping("/write")
	public String write() {
		return "/write";
	}

	//글 저장
	@PostMapping("/write")
	public String write(Guestbook gb) {
		int n = service.insert(gb);
		return "redirect:/list";
	}
	
	//글 삭제
	@PostMapping("/delete")
	public String delete(Guestbook gb) {
		log.debug("전달된 삭제 정보 {}", gb);
		int n = service.delete(gb);
		if (n == 0) {
			log.debug("삭제 실패");
		}
		else {
			log.debug("삭제 성공");
		}
		return "redirect:/list";
	}


}
