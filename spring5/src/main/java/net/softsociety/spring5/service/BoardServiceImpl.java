package net.softsociety.spring5.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
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
	public ArrayList<Board> list(String type, String searchWord) {
		HashMap<String, String> map = new HashMap<>();
		map.put("type", type);
		map.put("searchWord", searchWord);
		
		//조회 결과 중 위치, 개수 지정
		RowBounds rb = new RowBounds(0, 10);
		
		ArrayList<Board> list = dao.list(map, rb);
		return list;
	}
	
	@Override
	public Board read(int num) {
		//조회수 1증가
		dao.add(num);
		//글 정보 읽기
		Board board = dao.selectboard(num);
		return board;
	}

	@Override
	public int total() {
		RowBounds rb = new RowBounds(4, 10);
		return 0;
	}
	
	
}
