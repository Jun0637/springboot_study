package net.softsociety.spring5.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.softsociety.spring5.dao.MemberDAO;
import net.softsociety.spring5.domain.Member;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDAO dao;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Override
	public int insert(Member member) {
		//비밀번호 암호화
		String pw = encoder.encode(member.getMemberpw());//비번 꺼내옴
		member.setMemberpw(pw);//비번 암호화해서 넣음
		
		int n = dao.insert(member);
		return n;
	}

	@Override
	public boolean idcheck(String id) {
		Member member = dao.select(id);
//		boolean res;
//		if (member == null) {
//			res = false;			
//		}
//		else {
//			res = true;
//		}
//		return res;

		return member != null;
	}

	@Override
	public Member getMember(String id) {
		Member member = dao.select(id);		
		return member;
	}
	
	@Override
	public int updateMember(Member member) {

		//수정할 비밀번호 있으면 암호화
		if(member.getMemberpw() != null && member.getMemberpw().length() != 0) {
			String pw = encoder.encode(member.getMemberpw());//비번 꺼내옴
			member.setMemberpw(pw);//비번 암호화해서 넣음
		}
		int n = dao.updateMember(member);
		return n;

	}
	
	@Override
	public int delete(Member member) {
		if(encoder.matches(member.getMemberpw(), encoder.encode(member.getMemberpw()))){
			int n = dao.delete(member);		
			return n;
		}
		return 0;
	}

	@Override
	public ArrayList<Member> selectAll() {
		ArrayList<Member> list = dao.selectAll();
		return list;
	}

	
}
