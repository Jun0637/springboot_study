package net.softsociety.ajax.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.softsociety.ajax.dao.CommentDAO;
import net.softsociety.ajax.domain.Comment;

@Service
public class CommentService {
	@Autowired
	CommentDAO dao;
	
	//저장
	public int insertComment(Comment c) {
		int cnt = dao.insertComment(c);
		return cnt;
	}
	//목록 읽기
	public ArrayList<Comment> listComment() {
		ArrayList<Comment> list = dao.listComment();
		return list;
	}
	//삭제
	public int deleteComment(int num) {
		int cnt = dao.deleteComment(num);
		return cnt;
	}
	
}
