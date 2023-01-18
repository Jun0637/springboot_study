package net.softsociety.spring3.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.ui.Model;

import net.softsociety.spring3.domain.Person;

/**
 * Mybatis의 매퍼 인터페이스
 */
@Mapper
public interface PersonDAO {
	//저장
	public int insertPerson(Person p);
	//1명 삭제
	public int deletePerson(String idnum);
	//이름 삭제
	public int delete2Person(String name);
	//주민등록번호로 1명 조회
	public Person selectOne(String idnum);
	//모든 회원 조회
	public ArrayList<Person> select();
}
