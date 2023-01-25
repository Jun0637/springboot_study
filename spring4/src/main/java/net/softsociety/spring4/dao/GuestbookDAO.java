package net.softsociety.spring4.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.spring4.domain.Guestbook;

/**
 * Mybatis의 매퍼 인터페이스
 */
@Mapper
public interface GuestbookDAO {
	//저장
	public int insert(Guestbook gb);
	//전체 읽기
	public ArrayList<Guestbook> list();
	//삭제
	public int delete(Guestbook gb);
}
