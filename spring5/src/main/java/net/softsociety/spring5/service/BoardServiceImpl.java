package net.softsociety.spring5.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.softsociety.spring5.dao.BoardDAO;
import net.softsociety.spring5.domain.Board;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO dao;

	@Autowired
	PasswordEncoder encoder;
	
	@Override
	public int insertboard(Board board) {
		int n = dao.insertboard(board);
		return n;
	}

	@Override
	public Board selectboard(int boardnum) {
		Board board = dao.selectboard(boardnum);
		return board;
	}

	@Override
	public int updateboard(Board board) {
		int n = dao.deleteboard(board);
		return n;
	}

	@Override
	public int deleteboard(Board board) {
		int n = dao.deleteboard(board);
		return n;
	}

	@Override
	public ArrayList<Board> list() {
		ArrayList<Board> list = dao.list();
		return list;
	}
	
	
}
