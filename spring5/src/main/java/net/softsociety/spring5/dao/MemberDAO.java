package net.softsociety.spring5.dao;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.spring5.domain.Member;

@Mapper
public interface MemberDAO {
	//회원 정보 저장
	int insert(Member member);
	
	//회원 정보 조회
	Member select(String id);
	
	boolean idcheck(String id);
	
	Member getMember(String id);
}
