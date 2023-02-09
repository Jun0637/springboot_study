package net.softsociety.spring5.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import net.softsociety.spring5.domain.Board;


/**
 * 게시판 글 저장
 */
@Service
public interface BoardService {

	//글 저장
	public int insertboard(Board board);
	//글 제목으로 한개 조회
	public Board selectboard(int boardnum);
	//글 수정
	public int updateboard(Board board);
	//글 삭제
	public int deleteboard(Board board);
	//글 개수
	public int total();
	//전체 글 조회
	public ArrayList<Board> list(String type, String searchWord);
	
	public Board read(int num); 

}
