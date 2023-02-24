package net.softsociety.ajax.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.ajax.domain.Comment;
import net.softsociety.ajax.service.CommentService;

@Slf4j
@Controller
@RequestMapping("aj")
@ResponseBody
public class CommentRestController {
		/*
		 * 서비스에 필요한 기능들
		 1. 이름과 글내용 전달받아 DB에 저장
		 2. 번호를 전달받아 DB에서 삭제
		 3. DB의 모든 정보를 ArrayList<Comment>로 리턴
		 */

	@Autowired
	CommentService service;
	
	@PostMapping("insertComment")
	public void insert(Comment c) {
		//서비스로 전달해서 DB에 저장
		log.info("전달된 객체 : {}", c);
		service.insertComment(c);
	}
	
	@GetMapping("list")
	public ArrayList<Comment> list() {
		ArrayList<Comment> list = service.listComment();
		return list;
	}
	
	@GetMapping ("deleteComment")
	public int delete(int num) {
		log.info("전달된 번호 : {}", num);
		int res = service.deleteComment(num);
		return res;
	}	
}
