package net.softsociety.spring5.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.spring5.domain.Member;

@Mapper
public interface MemberDAO {
	//회원정보 저장
	int insert(Member member);
	//회원정보 조회
	Member select(String memberid);
	//회원정보 수정
	int updateMember(Member member);
	//회원 탈퇴
	int delete(Member member);
	//회원 멤버 보기
	ArrayList<Member> selectAll();

}
