package net.softsociety.spring5.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import net.softsociety.spring5.domain.Board;

@Mapper
public interface BoardDAO {
	//글 저장
	public int insertboard(Board board);
	//글 제목으로 한개 조회
	public Board selectboard(int boardnum);
	//글 수정
	public int updateboard(Board board);
	//글 삭제
	public int deleteboard(Board board);
	//전체 글 조회
	public ArrayList<Board> list(HashMap<String, String> map, RowBounds r);
	
	public int add(int num);
}
