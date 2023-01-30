package net.softsociety.spring5.service;

import org.springframework.stereotype.Service;

import net.softsociety.spring5.domain.Member;

@Service
public interface MemberService {
	/**
	 * 회원정보 저장 (가입)
	 * @param member 가입양식에서 전달된 회원정보
	 * @return 저장된 개수
	 */
	public int insert(Member member);
	
	/**
	 * 아이디 존재 확인
	 * @param id 찾을 아이디
	 * @return	해당 아이디 존재 여부 (있으면 true)
	 */
	public boolean idcheck(String id);
	
	/**
	 * 아이디로 회원 정보 찾기
	 * @param id 검색할 아이디
	 * @return	해당 회원의 정보
	 */
	public Member getMember(String id);
}
