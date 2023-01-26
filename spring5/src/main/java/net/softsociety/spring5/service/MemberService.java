package net.softsociety.spring5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.softsociety.spring5.dao.MemberDAO;
import net.softsociety.spring5.domain.Member;

@Service
public class MemberService {
	
	@Autowired
	MemberDAO dao;

	public int insert(Member member) {
		int n = dao.insert(member);
		return n;
	}

}
